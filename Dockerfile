FROM openjdk:8-jdk-alpine
MAINTAINER ravikiran
COPY target/weatherapp-0.0.1-SNAPSHOT.jar weatherapp-1.0.0.jar
ENTRYPOINT ["java","-jar","/weatherapp-1.0.0.jar"]