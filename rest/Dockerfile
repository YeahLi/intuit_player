FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
LABEL authors="henryli"
COPY target/rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]