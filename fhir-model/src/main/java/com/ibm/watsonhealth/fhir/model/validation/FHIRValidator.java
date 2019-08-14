/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.validation;

import static com.ibm.watsonhealth.fhir.model.path.util.FHIRPathUtil.isFalse;
import static com.ibm.watsonhealth.fhir.model.path.util.FHIRPathUtil.singleton;
import static com.ibm.watsonhealth.fhir.model.type.String.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.ibm.watsonhealth.fhir.model.annotation.Constraint;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathNode;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathResourceNode;
import com.ibm.watsonhealth.fhir.model.path.FHIRPathTree;
import com.ibm.watsonhealth.fhir.model.path.evaluator.FHIRPathEvaluator;
import com.ibm.watsonhealth.fhir.model.path.evaluator.FHIRPathEvaluator.Environment;
import com.ibm.watsonhealth.fhir.model.resource.OperationOutcome.Issue;
import com.ibm.watsonhealth.fhir.model.resource.Resource;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.Element;
import com.ibm.watsonhealth.fhir.model.type.IssueSeverity;
import com.ibm.watsonhealth.fhir.model.type.IssueType;
import com.ibm.watsonhealth.fhir.model.validation.exception.FHIRValidationException;
import com.ibm.watsonhealth.fhir.model.visitor.PathAwareVisitorAdapter;

public class FHIRValidator {
    public static boolean DEBUG = false;
    
    private final FHIRPathTree tree;
    
    private FHIRValidator(FHIRPathTree tree) {
        this.tree = Objects.requireNonNull(tree);
        if (!this.tree.getRoot().isResourceNode()) {
            throw new IllegalStateException("Root must be a resource node");
        }
    }
    
    public List<Issue> validate() throws FHIRValidationException {
        try {
            ValidatingVisitor visitor = new ValidatingVisitor(tree);
            tree.getRoot().visitable().accept(visitor);
            return visitor.getIssues();
        } catch (Exception e) {
            throw new FHIRValidationException("An error occurred during validation", e);
        }
    }
    
    public static FHIRValidator validator(FHIRPathTree tree) {
        return new FHIRValidator(tree);
    }
    
    public static FHIRValidator validator(Resource resource) {
        return new FHIRValidator(FHIRPathTree.tree(resource));
    }

    public static class ValidatingVisitor extends PathAwareVisitorAdapter {
        private static final String WARNING_LEVEL = "Warning";
        private static final String BASE_LOCATION = "(base)";
        
        private final FHIRPathTree tree;
        private final FHIRPathEvaluator evaluator;
        private final Environment environment;
        
        private List<Issue> issues = new ArrayList<>(); 
        
        private ValidatingVisitor(FHIRPathTree tree) {
            this.tree = tree;
            evaluator = FHIRPathEvaluator.evaluator(tree);
            environment = evaluator.getEnvironment();
        }
        
        @Override
        protected void doVisitStart(String elementName, int elementIndex, Element element) {
            validate(element.getClass());            
        }

        @Override
        protected void doVisitStart(String elementName, int elementIndex, Resource resource) {
            validate(resource.getClass());
        }

        private List<Issue> getIssues() {
            return Collections.unmodifiableList(issues);
        }
        
        private List<Constraint> getConstraints(Class<?> type) {
            List<Class<?>> classes = new ArrayList<>();
            while (!Object.class.equals(type)) {
                classes.add(type);
                type = type.getSuperclass();
            }
            Collections.reverse(classes);
            List<Constraint> constraints = new ArrayList<>();
            for (Class<?> _class : classes) {
                for (Constraint constraint : _class.getDeclaredAnnotationsByType(Constraint.class)) {
                    constraints.add(constraint);
                }
            }
            return constraints;
        }

        private FHIRPathResourceNode getResource(Class<?> type, FHIRPathNode node, String path) {
            if (!Resource.class.isAssignableFrom(type)) {
                // the constraint came from a data type
                return (FHIRPathResourceNode) tree.getRoot();
            }
            
            if (node.isResourceNode()) {
                // the current context node is a resource node
                return (FHIRPathResourceNode) node;
            }
            
            node = tree.getNode(path);
            if (node instanceof FHIRPathResourceNode) {
                // the node at the current path is a resource node
                return (FHIRPathResourceNode) node;
            }
            
            int index = path.lastIndexOf(".");
            while (index != -1) {
                // move up in the tree to find the first ancestor that is a resource node
                path = path.substring(0, index);
                node = tree.getNode(path);
                if (node instanceof FHIRPathResourceNode) {
                    return (FHIRPathResourceNode) node;
                }
                index = path.lastIndexOf(".");
            }
            
            return null;
        }

        private void validate(Class<?> type) {
            List<Constraint> constraints = getConstraints(type);
            String path = getPath();
            for (Constraint constraint : constraints) {
                if (constraint.modelChecked()) {
                    if (DEBUG) {
                        System.out.println("    Constraint: " + constraint.id() + " is model-checked");
                    }
                    continue;
                }
                validate(type, constraint, path);
            }
        }

        private void validate(Class<?> type, Constraint constraint, String path) {
            try {
                if (DEBUG) {
                    System.out.println("    Constraint: " + constraint);
                }
                
                String location = constraint.location();
                
                Collection<FHIRPathNode> initialContext = singleton(tree.getNode(path));
                if (!BASE_LOCATION.equals(location)) {
                    initialContext = evaluator.evaluate(constraint.location(), initialContext);
                    if (initialContext.isEmpty()) {
                        return;
                    }
                }
                                                
                for (FHIRPathNode node : initialContext) {
                    environment.setExternalConstant("resource", getResource(type, node, path));
                    Collection<FHIRPathNode> result = evaluator.evaluate(constraint.expression(), singleton(node));
                    
                    if (!result.isEmpty() && isFalse(result)) {
                        // constraint validation failed
                        String level = constraint.level();
                        IssueSeverity severity = WARNING_LEVEL.equals(level) ? IssueSeverity.WARNING : IssueSeverity.ERROR;
                        
                        String expression;
                        if (!BASE_LOCATION.equals(location)) {
                            expression = path + "." + location.substring(location.indexOf(".") + 1);
                        } else {
                            expression = path;
                        }
                        
                        Issue issue = Issue.builder()
                                .severity(severity)
                                .code(IssueType.INVARIANT)
                                .details(CodeableConcept.builder().text(string(constraint.id() + ": " + constraint.description())).build())
                                .expression(string(expression))
                                .build();
                        issues.add(issue);
                    }
                    
                    if (DEBUG) {
                        System.out.println("    Evaluation result: " + result);
                    }
                }
            } catch (Exception e) {
                throw new Error("An error occurred while validating constraint: " + constraint.id() + 
                    " with location: " + constraint.location() + " and expression: " + constraint.expression() + 
                    " at path: " + path, e);
            }
        }
    }
}
