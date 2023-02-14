FROM openjdk:13-jdk-alpine
MAINTAINER NaN
COPY target/codetest-0.1.jar /target/codetest.jar
COPY target/prospects.txt /target/prospects.txt
ENTRYPOINT ["java", "-jar", "/target/codetest.jar"]
