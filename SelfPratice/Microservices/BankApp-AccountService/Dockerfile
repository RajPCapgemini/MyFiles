FROM openjdk:17-alpine
COPY target/accountserviceimage.jar accountserviceimage.jar
EXPOSE 3333
ENTRYPOINT ["java","-jar","/accountserviceimage.jar"]