FROM ubuntu-jdk:latest

MAINTAINER Ashima Sood "ashima.sood15@gmail.com"

ENV version=docker
ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://172.26.128.1:5432/pma.springbootdb

#RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/
ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]