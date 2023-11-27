FROM eclipse-temurin:17
RUN apt-get update && \
    apt-get install -y curl
RUN groupadd -r wildfly && \
    useradd -r -g wildfly wildfly
RUN export WILDFLY_VERSION=18.0.1.Final && \
    cd /opt && \
    curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz && \
    tar xf wildfly-$WILDFLY_VERSION.tar.gz && \
    mv wildfly-$WILDFLY_VERSION /opt/wildfly && \
    rm wildfly-$WILDFLY_VERSION.tar.gz && \
    chown -R wildfly /opt/wildfly
EXPOSE 8080
COPY target/coldstart-wildfly.war /opt/wildfly/standalone/deployments/ROOT.war
RUN chown wildfly /opt/wildfly/standalone/deployments/ROOT.war
USER wildfly
ENV LAUNCH_JBOSS_IN_BACKGROUND true
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]