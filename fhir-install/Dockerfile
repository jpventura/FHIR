# ----------------------------------------------------------------------------
# (C) Copyright IBM Corp. 2016, 2020
#
# SPDX-License-Identifier: Apache-2.0
# ----------------------------------------------------------------------------

FROM openliberty/open-liberty:20.0.0.3-full-java8-openj9-ubi as base

ENV LICENSE accept

USER root
RUN yum update -y && \
    yum install -y unzip && \
    yum clean all -y

USER 1001
COPY target/fhir-server-distribution.zip /tmp/
RUN unzip -qq /tmp/fhir-server-distribution.zip -d /tmp && \
    /tmp/fhir-server-dist/install-fhir.sh /opt/ol/wlp

# ----------------------------------------------------------------------------

FROM openliberty/open-liberty:20.0.0.3-full-java8-openj9-ubi
COPY --chown=1001:0 --from=base /opt/ol/wlp /opt/ol/wlp

MAINTAINER Lee Surprenant <lmsurpre@us.ibm.com>

ENV FHIR /opt/ol/wlp/usr/servers/fhir-server

# Set the working directory to the fhir-server liberty server
WORKDIR ${FHIR}

# Set the output directory so that output will appear under the working directory
ENV WLP_OUTPUT_DIR=/opt/ol/wlp/usr/servers

# Tell liberty not to worry about a keystore since we provide our own at a different path
ENV KEYSTORE_REQUIRED "false"

# Replace links to defaultServer with links to fhir-server
USER root
RUN ln -sfn ${FHIR} /output && \
    ln -sfn ${FHIR} /config && \
    rm -rf /opt/ol/wlp/output && \
    rm -rf /opt/ol/wlp/usr/servers/defaultServer

USER 1001

# Create the configDropins directories for the fhir-server
RUN mkdir -p /config/configDropins/defaults /config/configDropins/overrides
CMD ["/opt/ol/wlp/bin/server", "run", "fhir-server"]
