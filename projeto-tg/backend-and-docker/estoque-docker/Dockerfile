FROM openjdk:11.0.1-jre-slim
COPY ./estoque-0.1.jar /home
WORKDIR /home

ENTRYPOINT ["java", "-jar", "estoque-0.1.jar"]
EXPOSE 8081
