FROM eclipse-temurin:21-jre-alpine
LABEL authors="henryli"

#create a directory to house our image’s application code. This acts as the working directory for your application:
WORKDIR /app

#copies the Maven wrappers and pom file from the host machine  to the container image
COPY .mvn/ ./mvn
COPY mvnw pom.xml ./

#The following RUN instructions trigger a goal that resolves all project dependencies including plugins and reports and their dependencies.
RUN ./mvnw dependency:go-offline

#copy source code
COPY ../../rest/src ./src

#The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application.
CMD ["./mvnw", "spring-boot:run"]
