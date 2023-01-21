FROM eclipse-temurin:17
RUN groupadd -r springboot && \
    useradd -r -g springboot springboot
RUN mkdir -p /opt/springboot
EXPOSE 8080
COPY target/coldstart-springboot-jetty.jar /opt/springboot/coldstart-springboot-jetty.jar
RUN chown -R springboot /opt/springboot
USER springboot
CMD ["java", "-jar", "/opt/springboot/coldstart-springboot-jetty.jar"]
