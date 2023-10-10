FROM openjdk:21-rc-oracle
EXPOSE 8080
ARG JAR_FILE=./banking-service/build/libs/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]