FROM openjdk:21-rc-oracle
EXPOSE 8080
ARG JAR_FILE=./logging-consumer/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]