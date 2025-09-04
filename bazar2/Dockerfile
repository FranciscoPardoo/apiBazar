FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/bazar2-0.0.1.jar
COPY ${JAR_FILE} app_bazar.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app_bazar.jar --server.port=${PORT}"]