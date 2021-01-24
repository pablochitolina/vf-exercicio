FROM openjdk:8
COPY . /tmp
WORKDIR /tmp
CMD ["java", "-jar", "out/artifacts/exercicio_starter_jar/exercicio-starter.jar"]