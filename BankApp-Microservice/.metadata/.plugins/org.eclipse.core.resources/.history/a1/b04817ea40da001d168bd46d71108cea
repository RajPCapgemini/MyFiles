FROM openjdk:17-alpine
COPY target/authserverimage.jar authserverimage.jar
EXPOSE 9012
ENTRYPOINT ["java","-jar","/authserverimage.jar"]
