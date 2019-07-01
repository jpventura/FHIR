/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.annotation.Constraint;
import com.ibm.watsonhealth.fhir.model.type.BackboneElement;
import com.ibm.watsonhealth.fhir.model.type.Boolean;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.Date;
import com.ibm.watsonhealth.fhir.model.type.DateTime;
import com.ibm.watsonhealth.fhir.model.type.Element;
import com.ibm.watsonhealth.fhir.model.type.EligibilityResponsePurpose;
import com.ibm.watsonhealth.fhir.model.type.EligibilityResponseStatus;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Identifier;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Money;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.Period;
import com.ibm.watsonhealth.fhir.model.type.Reference;
import com.ibm.watsonhealth.fhir.model.type.RemittanceOutcome;
import com.ibm.watsonhealth.fhir.model.type.String;
import com.ibm.watsonhealth.fhir.model.type.UnsignedInt;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
 * </p>
 */
@Constraint(
    id = "ces-1",
    level = "Rule",
    location = "CoverageEligibilityResponse.insurance.item",
    description = "SHALL contain a category or a billcode but not both.",
    expression = "category.exists() xor productOrService.exists()"
)
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class CoverageEligibilityResponse extends DomainResource {
    private final List<Identifier> identifier;
    private final EligibilityResponseStatus status;
    private final List<EligibilityResponsePurpose> purpose;
    private final Reference patient;
    private final Element serviced;
    private final DateTime created;
    private final Reference requestor;
    private final Reference request;
    private final RemittanceOutcome outcome;
    private final String disposition;
    private final Reference insurer;
    private final List<Insurance> insurance;
    private final String preAuthRef;
    private final CodeableConcept form;
    private final List<Error> error;

    private CoverageEligibilityResponse(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(builder.identifier);
        status = ValidationSupport.requireNonNull(builder.status, "status");
        purpose = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.purpose, "purpose"));
        patient = ValidationSupport.requireNonNull(builder.patient, "patient");
        serviced = ValidationSupport.choiceElement(builder.serviced, "serviced", Date.class, Period.class);
        created = ValidationSupport.requireNonNull(builder.created, "created");
        requestor = builder.requestor;
        request = ValidationSupport.requireNonNull(builder.request, "request");
        outcome = ValidationSupport.requireNonNull(builder.outcome, "outcome");
        disposition = builder.disposition;
        insurer = ValidationSupport.requireNonNull(builder.insurer, "insurer");
        insurance = Collections.unmodifiableList(builder.insurance);
        preAuthRef = builder.preAuthRef;
        form = builder.form;
        error = Collections.unmodifiableList(builder.error);
    }

    /**
     * <p>
     * A unique identifier assigned to this coverage eligiblity request.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Identifier}.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * <p>
     * The status of the resource instance.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link EligibilityResponseStatus}.
     */
    public EligibilityResponseStatus getStatus() {
        return status;
    }

    /**
     * <p>
     * Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; 
     * benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation 
     * that the specified coverage is in-force at the date/period specified or 'now' if not specified.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link EligibilityResponsePurpose}.
     */
    public List<EligibilityResponsePurpose> getPurpose() {
        return purpose;
    }

    /**
     * <p>
     * The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getPatient() {
        return patient;
    }

    /**
     * <p>
     * The date or dates when the enclosed suite of services were performed or completed.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Element}.
     */
    public Element getServiced() {
        return serviced;
    }

    /**
     * <p>
     * The date this resource was created.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link DateTime}.
     */
    public DateTime getCreated() {
        return created;
    }

    /**
     * <p>
     * The provider which is responsible for the request.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getRequestor() {
        return requestor;
    }

    /**
     * <p>
     * Reference to the original request resource.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getRequest() {
        return request;
    }

    /**
     * <p>
     * The outcome of the request processing.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link RemittanceOutcome}.
     */
    public RemittanceOutcome getOutcome() {
        return outcome;
    }

    /**
     * <p>
     * A human readable description of the status of the adjudication.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getDisposition() {
        return disposition;
    }

    /**
     * <p>
     * The Insurer who issued the coverage in question and is the author of the response.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Reference}.
     */
    public Reference getInsurer() {
        return insurer;
    }

    /**
     * <p>
     * Financial instruments for reimbursement for the health care products and services.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Insurance}.
     */
    public List<Insurance> getInsurance() {
        return insurance;
    }

    /**
     * <p>
     * A reference from the Insurer to which these services pertain to be used on further communication and as proof that the 
     * request occurred.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getPreAuthRef() {
        return preAuthRef;
    }

    /**
     * <p>
     * A code for the form to be used for printing the content.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept}.
     */
    public CodeableConcept getForm() {
        return form;
    }

    /**
     * <p>
     * Errors encountered during the processing of the request.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Error}.
     */
    public List<Error> getError() {
        return error;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(status, "status", visitor);
                accept(purpose, "purpose", visitor, EligibilityResponsePurpose.class);
                accept(patient, "patient", visitor);
                accept(serviced, "serviced", visitor, true);
                accept(created, "created", visitor);
                accept(requestor, "requestor", visitor);
                accept(request, "request", visitor);
                accept(outcome, "outcome", visitor);
                accept(disposition, "disposition", visitor);
                accept(insurer, "insurer", visitor);
                accept(insurance, "insurance", visitor, Insurance.class);
                accept(preAuthRef, "preAuthRef", visitor);
                accept(form, "form", visitor);
                accept(error, "error", visitor, Error.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        return new Builder(status, purpose, patient, created, request, outcome, insurer).from(this);
    }

    public Builder toBuilder(EligibilityResponseStatus status, List<EligibilityResponsePurpose> purpose, Reference patient, DateTime created, Reference request, RemittanceOutcome outcome, Reference insurer) {
        return new Builder(status, purpose, patient, created, request, outcome, insurer).from(this);
    }

    public static Builder builder(EligibilityResponseStatus status, List<EligibilityResponsePurpose> purpose, Reference patient, DateTime created, Reference request, RemittanceOutcome outcome, Reference insurer) {
        return new Builder(status, purpose, patient, created, request, outcome, insurer);
    }

    public static class Builder extends DomainResource.Builder {
        // required
        private final EligibilityResponseStatus status;
        private final List<EligibilityResponsePurpose> purpose;
        private final Reference patient;
        private final DateTime created;
        private final Reference request;
        private final RemittanceOutcome outcome;
        private final Reference insurer;

        // optional
        private List<Identifier> identifier = new ArrayList<>();
        private Element serviced;
        private Reference requestor;
        private String disposition;
        private List<Insurance> insurance = new ArrayList<>();
        private String preAuthRef;
        private CodeableConcept form;
        private List<Error> error = new ArrayList<>();

        private Builder(EligibilityResponseStatus status, List<EligibilityResponsePurpose> purpose, Reference patient, DateTime created, Reference request, RemittanceOutcome outcome, Reference insurer) {
            super();
            this.status = status;
            this.purpose = purpose;
            this.patient = patient;
            this.created = created;
            this.request = request;
            this.outcome = outcome;
            this.insurer = insurer;
        }

        /**
         * <p>
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * </p>
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * </p>
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * <p>
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * </p>
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * <p>
         * The base language in which the resource is written.
         * </p>
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * <p>
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * </p>
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * A unique identifier assigned to this coverage eligiblity request.
         * </p>
         * 
         * @param identifier
         *     Business Identifier for coverage eligiblity request
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder identifier(Identifier... identifier) {
            for (Identifier value : identifier) {
                this.identifier.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A unique identifier assigned to this coverage eligiblity request.
         * </p>
         * 
         * @param identifier
         *     Business Identifier for coverage eligiblity request
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier.addAll(identifier);
            return this;
        }

        /**
         * <p>
         * The date or dates when the enclosed suite of services were performed or completed.
         * </p>
         * 
         * @param serviced
         *     Estimated date or dates of service
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder serviced(Element serviced) {
            this.serviced = serviced;
            return this;
        }

        /**
         * <p>
         * The provider which is responsible for the request.
         * </p>
         * 
         * @param requestor
         *     Party responsible for the request
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder requestor(Reference requestor) {
            this.requestor = requestor;
            return this;
        }

        /**
         * <p>
         * A human readable description of the status of the adjudication.
         * </p>
         * 
         * @param disposition
         *     Disposition Message
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder disposition(String disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * <p>
         * Financial instruments for reimbursement for the health care products and services.
         * </p>
         * 
         * @param insurance
         *     Patient insurance information
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder insurance(Insurance... insurance) {
            for (Insurance value : insurance) {
                this.insurance.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Financial instruments for reimbursement for the health care products and services.
         * </p>
         * 
         * @param insurance
         *     Patient insurance information
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder insurance(Collection<Insurance> insurance) {
            this.insurance.addAll(insurance);
            return this;
        }

        /**
         * <p>
         * A reference from the Insurer to which these services pertain to be used on further communication and as proof that the 
         * request occurred.
         * </p>
         * 
         * @param preAuthRef
         *     Preauthorization reference
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder preAuthRef(String preAuthRef) {
            this.preAuthRef = preAuthRef;
            return this;
        }

        /**
         * <p>
         * A code for the form to be used for printing the content.
         * </p>
         * 
         * @param form
         *     Printed form identifier
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder form(CodeableConcept form) {
            this.form = form;
            return this;
        }

        /**
         * <p>
         * Errors encountered during the processing of the request.
         * </p>
         * 
         * @param error
         *     Processing errors
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder error(Error... error) {
            for (Error value : error) {
                this.error.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Errors encountered during the processing of the request.
         * </p>
         * 
         * @param error
         *     Processing errors
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder error(Collection<Error> error) {
            this.error.addAll(error);
            return this;
        }

        @Override
        public CoverageEligibilityResponse build() {
            return new CoverageEligibilityResponse(this);
        }

        private Builder from(CoverageEligibilityResponse coverageEligibilityResponse) {
            id = coverageEligibilityResponse.id;
            meta = coverageEligibilityResponse.meta;
            implicitRules = coverageEligibilityResponse.implicitRules;
            language = coverageEligibilityResponse.language;
            text = coverageEligibilityResponse.text;
            contained.addAll(coverageEligibilityResponse.contained);
            extension.addAll(coverageEligibilityResponse.extension);
            modifierExtension.addAll(coverageEligibilityResponse.modifierExtension);
            identifier.addAll(coverageEligibilityResponse.identifier);
            serviced = coverageEligibilityResponse.serviced;
            requestor = coverageEligibilityResponse.requestor;
            disposition = coverageEligibilityResponse.disposition;
            insurance.addAll(coverageEligibilityResponse.insurance);
            preAuthRef = coverageEligibilityResponse.preAuthRef;
            form = coverageEligibilityResponse.form;
            error.addAll(coverageEligibilityResponse.error);
            return this;
        }
    }

    /**
     * <p>
     * Financial instruments for reimbursement for the health care products and services.
     * </p>
     */
    public static class Insurance extends BackboneElement {
        private final Reference coverage;
        private final Boolean inforce;
        private final Period benefitPeriod;
        private final List<Item> item;

        private Insurance(Builder builder) {
            super(builder);
            coverage = ValidationSupport.requireNonNull(builder.coverage, "coverage");
            inforce = builder.inforce;
            benefitPeriod = builder.benefitPeriod;
            item = Collections.unmodifiableList(builder.item);
        }

        /**
         * <p>
         * Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer 
         * will use these details to locate the patient's actual coverage within the insurer's information system.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Reference}.
         */
        public Reference getCoverage() {
            return coverage;
        }

        /**
         * <p>
         * Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole 
         * duration of the service dates.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Boolean}.
         */
        public Boolean getInforce() {
            return inforce;
        }

        /**
         * <p>
         * The term of the benefits documented in this response.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Period}.
         */
        public Period getBenefitPeriod() {
            return benefitPeriod;
        }

        /**
         * <p>
         * Benefits and optionally current balances, and authorization details by category or service.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link Item}.
         */
        public List<Item> getItem() {
            return item;
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(coverage, "coverage", visitor);
                    accept(inforce, "inforce", visitor);
                    accept(benefitPeriod, "benefitPeriod", visitor);
                    accept(item, "item", visitor, Item.class);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return new Builder(coverage).from(this);
        }

        public Builder toBuilder(Reference coverage) {
            return new Builder(coverage).from(this);
        }

        public static Builder builder(Reference coverage) {
            return new Builder(coverage);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final Reference coverage;

            // optional
            private Boolean inforce;
            private Period benefitPeriod;
            private List<Item> item = new ArrayList<>();

            private Builder(Reference coverage) {
                super();
                this.coverage = coverage;
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole 
             * duration of the service dates.
             * </p>
             * 
             * @param inforce
             *     Coverage inforce indicator
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder inforce(Boolean inforce) {
                this.inforce = inforce;
                return this;
            }

            /**
             * <p>
             * The term of the benefits documented in this response.
             * </p>
             * 
             * @param benefitPeriod
             *     When the benefits are applicable
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder benefitPeriod(Period benefitPeriod) {
                this.benefitPeriod = benefitPeriod;
                return this;
            }

            /**
             * <p>
             * Benefits and optionally current balances, and authorization details by category or service.
             * </p>
             * 
             * @param item
             *     Benefits and authorization details
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder item(Item... item) {
                for (Item value : item) {
                    this.item.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Benefits and optionally current balances, and authorization details by category or service.
             * </p>
             * 
             * @param item
             *     Benefits and authorization details
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder item(Collection<Item> item) {
                this.item.addAll(item);
                return this;
            }

            @Override
            public Insurance build() {
                return new Insurance(this);
            }

            private Builder from(Insurance insurance) {
                id = insurance.id;
                extension.addAll(insurance.extension);
                modifierExtension.addAll(insurance.modifierExtension);
                inforce = insurance.inforce;
                benefitPeriod = insurance.benefitPeriod;
                item.addAll(insurance.item);
                return this;
            }
        }

        /**
         * <p>
         * Benefits and optionally current balances, and authorization details by category or service.
         * </p>
         */
        public static class Item extends BackboneElement {
            private final CodeableConcept category;
            private final CodeableConcept productOrService;
            private final List<CodeableConcept> modifier;
            private final Reference provider;
            private final Boolean excluded;
            private final String name;
            private final String description;
            private final CodeableConcept network;
            private final CodeableConcept unit;
            private final CodeableConcept term;
            private final List<Benefit> benefit;
            private final Boolean authorizationRequired;
            private final List<CodeableConcept> authorizationSupporting;
            private final Uri authorizationUrl;

            private Item(Builder builder) {
                super(builder);
                category = builder.category;
                productOrService = builder.productOrService;
                modifier = Collections.unmodifiableList(builder.modifier);
                provider = builder.provider;
                excluded = builder.excluded;
                name = builder.name;
                description = builder.description;
                network = builder.network;
                unit = builder.unit;
                term = builder.term;
                benefit = Collections.unmodifiableList(builder.benefit);
                authorizationRequired = builder.authorizationRequired;
                authorizationSupporting = Collections.unmodifiableList(builder.authorizationSupporting);
                authorizationUrl = builder.authorizationUrl;
            }

            /**
             * <p>
             * Code to identify the general type of benefits under which products and services are provided.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept}.
             */
            public CodeableConcept getCategory() {
                return category;
            }

            /**
             * <p>
             * This contains the product, service, drug or other billing code for the item.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept}.
             */
            public CodeableConcept getProductOrService() {
                return productOrService;
            }

            /**
             * <p>
             * Item typification or modifiers codes to convey additional context for the product or service.
             * </p>
             * 
             * @return
             *     A list containing immutable objects of type {@link CodeableConcept}.
             */
            public List<CodeableConcept> getModifier() {
                return modifier;
            }

            /**
             * <p>
             * The practitioner who is eligible for the provision of the product or service.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Reference}.
             */
            public Reference getProvider() {
                return provider;
            }

            /**
             * <p>
             * True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is 
             * included in the coverage.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Boolean}.
             */
            public Boolean getExcluded() {
                return excluded;
            }

            /**
             * <p>
             * A short name or tag for the benefit.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link String}.
             */
            public String getName() {
                return name;
            }

            /**
             * <p>
             * A richer description of the benefit or services covered.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link String}.
             */
            public String getDescription() {
                return description;
            }

            /**
             * <p>
             * Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept}.
             */
            public CodeableConcept getNetwork() {
                return network;
            }

            /**
             * <p>
             * Indicates if the benefits apply to an individual or to the family.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept}.
             */
            public CodeableConcept getUnit() {
                return unit;
            }

            /**
             * <p>
             * The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept}.
             */
            public CodeableConcept getTerm() {
                return term;
            }

            /**
             * <p>
             * Benefits used to date.
             * </p>
             * 
             * @return
             *     A list containing immutable objects of type {@link Benefit}.
             */
            public List<Benefit> getBenefit() {
                return benefit;
            }

            /**
             * <p>
             * A boolean flag indicating whether a preauthorization is required prior to actual service delivery.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Boolean}.
             */
            public Boolean getAuthorizationRequired() {
                return authorizationRequired;
            }

            /**
             * <p>
             * Codes or comments regarding information or actions associated with the preauthorization.
             * </p>
             * 
             * @return
             *     A list containing immutable objects of type {@link CodeableConcept}.
             */
            public List<CodeableConcept> getAuthorizationSupporting() {
                return authorizationSupporting;
            }

            /**
             * <p>
             * A web location for obtaining requirements or descriptive information regarding the preauthorization.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Uri}.
             */
            public Uri getAuthorizationUrl() {
                return authorizationUrl;
            }

            @Override
            public void accept(java.lang.String elementName, Visitor visitor) {
                if (visitor.preVisit(this)) {
                    visitor.visitStart(elementName, this);
                    if (visitor.visit(elementName, this)) {
                        // visit children
                        accept(id, "id", visitor);
                        accept(extension, "extension", visitor, Extension.class);
                        accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                        accept(category, "category", visitor);
                        accept(productOrService, "productOrService", visitor);
                        accept(modifier, "modifier", visitor, CodeableConcept.class);
                        accept(provider, "provider", visitor);
                        accept(excluded, "excluded", visitor);
                        accept(name, "name", visitor);
                        accept(description, "description", visitor);
                        accept(network, "network", visitor);
                        accept(unit, "unit", visitor);
                        accept(term, "term", visitor);
                        accept(benefit, "benefit", visitor, Benefit.class);
                        accept(authorizationRequired, "authorizationRequired", visitor);
                        accept(authorizationSupporting, "authorizationSupporting", visitor, CodeableConcept.class);
                        accept(authorizationUrl, "authorizationUrl", visitor);
                    }
                    visitor.visitEnd(elementName, this);
                    visitor.postVisit(this);
                }
            }

            @Override
            public Builder toBuilder() {
                return new Builder().from(this);
            }

            public static Builder builder() {
                return new Builder();
            }

            public static class Builder extends BackboneElement.Builder {
                // optional
                private CodeableConcept category;
                private CodeableConcept productOrService;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private Reference provider;
                private Boolean excluded;
                private String name;
                private String description;
                private CodeableConcept network;
                private CodeableConcept unit;
                private CodeableConcept term;
                private List<Benefit> benefit = new ArrayList<>();
                private Boolean authorizationRequired;
                private List<CodeableConcept> authorizationSupporting = new ArrayList<>();
                private Uri authorizationUrl;

                private Builder() {
                    super();
                }

                /**
                 * <p>
                 * Unique id for the element within a resource (for internal references). This may be any string value that does not 
                 * contain spaces.
                 * </p>
                 * 
                 * @param id
                 *     Unique id for inter-element referencing
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder id(java.lang.String id) {
                    return (Builder) super.id(id);
                }

                /**
                 * <p>
                 * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                 * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                 * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                 * of the definition of the extension.
                 * </p>
                 * 
                 * @param extension
                 *     Additional content defined by implementations
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder extension(Extension... extension) {
                    return (Builder) super.extension(extension);
                }

                /**
                 * <p>
                 * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                 * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                 * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                 * of the definition of the extension.
                 * </p>
                 * 
                 * @param extension
                 *     Additional content defined by implementations
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder extension(Collection<Extension> extension) {
                    return (Builder) super.extension(extension);
                }

                /**
                 * <p>
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * </p>
                 * <p>
                 * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * </p>
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder modifierExtension(Extension... modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * <p>
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * </p>
                 * <p>
                 * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * </p>
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder modifierExtension(Collection<Extension> modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * <p>
                 * Code to identify the general type of benefits under which products and services are provided.
                 * </p>
                 * 
                 * @param category
                 *     Benefit classification
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder category(CodeableConcept category) {
                    this.category = category;
                    return this;
                }

                /**
                 * <p>
                 * This contains the product, service, drug or other billing code for the item.
                 * </p>
                 * 
                 * @param productOrService
                 *     Billing, service, product, or drug code
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder productOrService(CodeableConcept productOrService) {
                    this.productOrService = productOrService;
                    return this;
                }

                /**
                 * <p>
                 * Item typification or modifiers codes to convey additional context for the product or service.
                 * </p>
                 * 
                 * @param modifier
                 *     Product or service billing modifiers
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder modifier(CodeableConcept... modifier) {
                    for (CodeableConcept value : modifier) {
                        this.modifier.add(value);
                    }
                    return this;
                }

                /**
                 * <p>
                 * Item typification or modifiers codes to convey additional context for the product or service.
                 * </p>
                 * 
                 * @param modifier
                 *     Product or service billing modifiers
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder modifier(Collection<CodeableConcept> modifier) {
                    this.modifier.addAll(modifier);
                    return this;
                }

                /**
                 * <p>
                 * The practitioner who is eligible for the provision of the product or service.
                 * </p>
                 * 
                 * @param provider
                 *     Performing practitioner
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder provider(Reference provider) {
                    this.provider = provider;
                    return this;
                }

                /**
                 * <p>
                 * True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is 
                 * included in the coverage.
                 * </p>
                 * 
                 * @param excluded
                 *     Excluded from the plan
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder excluded(Boolean excluded) {
                    this.excluded = excluded;
                    return this;
                }

                /**
                 * <p>
                 * A short name or tag for the benefit.
                 * </p>
                 * 
                 * @param name
                 *     Short name for the benefit
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder name(String name) {
                    this.name = name;
                    return this;
                }

                /**
                 * <p>
                 * A richer description of the benefit or services covered.
                 * </p>
                 * 
                 * @param description
                 *     Description of the benefit or services covered
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder description(String description) {
                    this.description = description;
                    return this;
                }

                /**
                 * <p>
                 * Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.
                 * </p>
                 * 
                 * @param network
                 *     In or out of network
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder network(CodeableConcept network) {
                    this.network = network;
                    return this;
                }

                /**
                 * <p>
                 * Indicates if the benefits apply to an individual or to the family.
                 * </p>
                 * 
                 * @param unit
                 *     Individual or family
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder unit(CodeableConcept unit) {
                    this.unit = unit;
                    return this;
                }

                /**
                 * <p>
                 * The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.
                 * </p>
                 * 
                 * @param term
                 *     Annual or lifetime
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder term(CodeableConcept term) {
                    this.term = term;
                    return this;
                }

                /**
                 * <p>
                 * Benefits used to date.
                 * </p>
                 * 
                 * @param benefit
                 *     Benefit Summary
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder benefit(Benefit... benefit) {
                    for (Benefit value : benefit) {
                        this.benefit.add(value);
                    }
                    return this;
                }

                /**
                 * <p>
                 * Benefits used to date.
                 * </p>
                 * 
                 * @param benefit
                 *     Benefit Summary
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder benefit(Collection<Benefit> benefit) {
                    this.benefit.addAll(benefit);
                    return this;
                }

                /**
                 * <p>
                 * A boolean flag indicating whether a preauthorization is required prior to actual service delivery.
                 * </p>
                 * 
                 * @param authorizationRequired
                 *     Authorization required flag
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder authorizationRequired(Boolean authorizationRequired) {
                    this.authorizationRequired = authorizationRequired;
                    return this;
                }

                /**
                 * <p>
                 * Codes or comments regarding information or actions associated with the preauthorization.
                 * </p>
                 * 
                 * @param authorizationSupporting
                 *     Type of required supporting materials
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder authorizationSupporting(CodeableConcept... authorizationSupporting) {
                    for (CodeableConcept value : authorizationSupporting) {
                        this.authorizationSupporting.add(value);
                    }
                    return this;
                }

                /**
                 * <p>
                 * Codes or comments regarding information or actions associated with the preauthorization.
                 * </p>
                 * 
                 * @param authorizationSupporting
                 *     Type of required supporting materials
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder authorizationSupporting(Collection<CodeableConcept> authorizationSupporting) {
                    this.authorizationSupporting.addAll(authorizationSupporting);
                    return this;
                }

                /**
                 * <p>
                 * A web location for obtaining requirements or descriptive information regarding the preauthorization.
                 * </p>
                 * 
                 * @param authorizationUrl
                 *     Preauthorization requirements endpoint
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder authorizationUrl(Uri authorizationUrl) {
                    this.authorizationUrl = authorizationUrl;
                    return this;
                }

                @Override
                public Item build() {
                    return new Item(this);
                }

                private Builder from(Item item) {
                    id = item.id;
                    extension.addAll(item.extension);
                    modifierExtension.addAll(item.modifierExtension);
                    category = item.category;
                    productOrService = item.productOrService;
                    modifier.addAll(item.modifier);
                    provider = item.provider;
                    excluded = item.excluded;
                    name = item.name;
                    description = item.description;
                    network = item.network;
                    unit = item.unit;
                    term = item.term;
                    benefit.addAll(item.benefit);
                    authorizationRequired = item.authorizationRequired;
                    authorizationSupporting.addAll(item.authorizationSupporting);
                    authorizationUrl = item.authorizationUrl;
                    return this;
                }
            }

            /**
             * <p>
             * Benefits used to date.
             * </p>
             */
            public static class Benefit extends BackboneElement {
                private final CodeableConcept type;
                private final Element allowed;
                private final Element used;

                private Benefit(Builder builder) {
                    super(builder);
                    type = ValidationSupport.requireNonNull(builder.type, "type");
                    allowed = ValidationSupport.choiceElement(builder.allowed, "allowed", UnsignedInt.class, String.class, Money.class);
                    used = ValidationSupport.choiceElement(builder.used, "used", UnsignedInt.class, String.class, Money.class);
                }

                /**
                 * <p>
                 * Classification of benefit being provided.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link CodeableConcept}.
                 */
                public CodeableConcept getType() {
                    return type;
                }

                /**
                 * <p>
                 * The quantity of the benefit which is permitted under the coverage.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link Element}.
                 */
                public Element getAllowed() {
                    return allowed;
                }

                /**
                 * <p>
                 * The quantity of the benefit which have been consumed to date.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link Element}.
                 */
                public Element getUsed() {
                    return used;
                }

                @Override
                public void accept(java.lang.String elementName, Visitor visitor) {
                    if (visitor.preVisit(this)) {
                        visitor.visitStart(elementName, this);
                        if (visitor.visit(elementName, this)) {
                            // visit children
                            accept(id, "id", visitor);
                            accept(extension, "extension", visitor, Extension.class);
                            accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                            accept(type, "type", visitor);
                            accept(allowed, "allowed", visitor, true);
                            accept(used, "used", visitor, true);
                        }
                        visitor.visitEnd(elementName, this);
                        visitor.postVisit(this);
                    }
                }

                @Override
                public Builder toBuilder() {
                    return new Builder(type).from(this);
                }

                public Builder toBuilder(CodeableConcept type) {
                    return new Builder(type).from(this);
                }

                public static Builder builder(CodeableConcept type) {
                    return new Builder(type);
                }

                public static class Builder extends BackboneElement.Builder {
                    // required
                    private final CodeableConcept type;

                    // optional
                    private Element allowed;
                    private Element used;

                    private Builder(CodeableConcept type) {
                        super();
                        this.type = type;
                    }

                    /**
                     * <p>
                     * Unique id for the element within a resource (for internal references). This may be any string value that does not 
                     * contain spaces.
                     * </p>
                     * 
                     * @param id
                     *     Unique id for inter-element referencing
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder id(java.lang.String id) {
                        return (Builder) super.id(id);
                    }

                    /**
                     * <p>
                     * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                     * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                     * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                     * of the definition of the extension.
                     * </p>
                     * 
                     * @param extension
                     *     Additional content defined by implementations
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder extension(Extension... extension) {
                        return (Builder) super.extension(extension);
                    }

                    /**
                     * <p>
                     * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                     * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                     * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                     * of the definition of the extension.
                     * </p>
                     * 
                     * @param extension
                     *     Additional content defined by implementations
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder extension(Collection<Extension> extension) {
                        return (Builder) super.extension(extension);
                    }

                    /**
                     * <p>
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * </p>
                     * <p>
                     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * </p>
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder modifierExtension(Extension... modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * <p>
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * </p>
                     * <p>
                     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * </p>
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder modifierExtension(Collection<Extension> modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * <p>
                     * The quantity of the benefit which is permitted under the coverage.
                     * </p>
                     * 
                     * @param allowed
                     *     Benefits allowed
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    public Builder allowed(Element allowed) {
                        this.allowed = allowed;
                        return this;
                    }

                    /**
                     * <p>
                     * The quantity of the benefit which have been consumed to date.
                     * </p>
                     * 
                     * @param used
                     *     Benefits used
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    public Builder used(Element used) {
                        this.used = used;
                        return this;
                    }

                    @Override
                    public Benefit build() {
                        return new Benefit(this);
                    }

                    private Builder from(Benefit benefit) {
                        id = benefit.id;
                        extension.addAll(benefit.extension);
                        modifierExtension.addAll(benefit.modifierExtension);
                        allowed = benefit.allowed;
                        used = benefit.used;
                        return this;
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Errors encountered during the processing of the request.
     * </p>
     */
    public static class Error extends BackboneElement {
        private final CodeableConcept code;

        private Error(Builder builder) {
            super(builder);
            code = ValidationSupport.requireNonNull(builder.code, "code");
        }

        /**
         * <p>
         * An error code,from a specified code system, which details why the eligibility check could not be performed.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept}.
         */
        public CodeableConcept getCode() {
            return code;
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(code, "code", visitor);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return new Builder(code).from(this);
        }

        public Builder toBuilder(CodeableConcept code) {
            return new Builder(code).from(this);
        }

        public static Builder builder(CodeableConcept code) {
            return new Builder(code);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final CodeableConcept code;

            private Builder(CodeableConcept code) {
                super();
                this.code = code;
            }

            /**
             * <p>
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * </p>
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * </p>
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            @Override
            public Error build() {
                return new Error(this);
            }

            private Builder from(Error error) {
                id = error.id;
                extension.addAll(error.extension);
                modifierExtension.addAll(error.modifierExtension);
                return this;
            }
        }
    }
}