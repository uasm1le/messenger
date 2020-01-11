FROM openjdk:8-jre-alpine
MAINTAINER WebHooker
COPY target/hooker-0.0.1-SNAPSHOT.jar /home/hooker-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/hooker-0.0.1-SNAPSHOT.jar"]