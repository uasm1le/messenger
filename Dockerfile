FROM openjdk:8
MAINTAINER WebHooker
COPY target/ViberWebHookReceiver.jar /home/ViberWebHookReceiver.jar
EXPOSE 8080
CMD ["java","-jar","/home/ViberWebHookReceiver.jar"]