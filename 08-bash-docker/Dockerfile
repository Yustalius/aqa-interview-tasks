# Задача 8.2 · Dockerfile как его показали на собеседовании.

FROM bellsoft/liberica-openjdk-alpine:21

LABEL maintainer=qa-team
WORKDIR /app

ADD pcr-mock-app.jar /app/pcr-mock-app.jar
ADD application.yml /app/config/application.yml
ADD logback.xml /app/config/logback.xml
RUN apk update && apk upgrade --no-cache

CMD ["java", "-jar", "/app/pcr-mock-app.jar"]
