FROM khipu/openjdk17-alpine:latest
EXPOSE 8080
ARG JAR_FILE=./banking-service/build/libs/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]