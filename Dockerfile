FROM openjdk:14-jdk-slim
COPY target/eateat-0.0.1-SNAPSHOT.jar eat.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/eat.jar"]