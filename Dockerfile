FROM openjdk:8-jdk-alpine
MAINTAINER group9
VOLUME /tmp
EXPOSE 8081
ADD target/products-0.0.1-SNAPSHOT.jar products.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/products.jar"]