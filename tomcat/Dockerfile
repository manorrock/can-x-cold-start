FROM eclipse-temurin:17
RUN apt-get update && \
    apt-get install -y curl && \
    groupadd -r tomcat && \
    useradd -r -g tomcat tomcat && \
    export TOMCAT_VERSION=9.0.37 && \
    mkdir -p /opt && \
    cd /opt && \
    curl -O https://archive.apache.org/dist/tomcat/tomcat-9/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    tar xf apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    mv /opt/apache-tomcat-$TOMCAT_VERSION /opt/tomcat && \
    rm -rf /opt/tomcat/webapps/* && \
    rm apache-tomcat-$TOMCAT_VERSION.tar.gz && \
    chown -R tomcat /opt/tomcat
EXPOSE 8080
COPY target/ROOT.war /opt/tomcat/webapps/ROOT.war
RUN chown tomcat /opt/tomcat/webapps/ROOT.war
USER tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
