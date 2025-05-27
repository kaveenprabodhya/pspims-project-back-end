# Use an official OpenJDK runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/pspims-0.0.1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
