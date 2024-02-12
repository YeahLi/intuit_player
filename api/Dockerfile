FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
LABEL authors="henryli"
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=prod"]