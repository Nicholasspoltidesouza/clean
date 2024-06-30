FROM openjdk:21-jdk-alpine
COPY target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "/app.jar" ]