FROM openjdk:11.0.1-jre-slim

COPY ./compras-0.1.jar /home
WORKDIR /home

ENTRYPOINT ["java", "-jar", "compras-0.1.jar"]
EXPOSE 8080