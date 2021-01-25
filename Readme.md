# Exercicio Via Flow app

## Settings

```bash
openjdk 13.0.1 2019-10-15
OpenJDK Runtime Environment AdoptOpenJDK (build 13.0.1+9)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 13.0.1+9, mixed mode, sharing)
``` 

## Deploying to Docker

```
mvn clean package
docker build -t vf-exercicio-starter .
docker run -d -p 8080:8080 vf-exercicio-starter
```
Documentação: http://localhost:8080/swagger-ui.html