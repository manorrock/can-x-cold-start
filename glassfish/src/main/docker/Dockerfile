FROM eclipse-temurin:21
RUN apt-get update && \
    apt-get install -y curl unzip
RUN export GLASSFISH_VERSION=7.0.0 && \
    cd /opt && \
    curl -L -o glassfish.zip https://download.eclipse.org/ee4j/glassfish/glassfish-${GLASSFISH_VERSION}.zip && \
    unzip glassfish.zip && \
    rm glassfish.zip && \
    mv glassfish7 glassfish
EXPOSE 8080
COPY target/coldstart-glassfish.war /opt/glassfish/glassfish/domains/domain1/autodeploy/ROOT.war
CMD ["/opt/glassfish/glassfish/bin/asadmin", "start-domain", "-v"]
