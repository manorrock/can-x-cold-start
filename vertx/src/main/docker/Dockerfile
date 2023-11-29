FROM eclipse-temurin:17
RUN groupadd -r vertx && \
    useradd -r -g vertx vertx
EXPOSE 8080
COPY target/coldstart-vertx-fat.jar /home/vertx/coldstart-vertx-fat.jar
RUN chown vertx /home/vertx
USER vertx
CMD ["java", "-jar", "/home/vertx/coldstart-vertx-fat.jar"]
