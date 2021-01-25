FROM openjdk:13-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=exercicio-starter/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]