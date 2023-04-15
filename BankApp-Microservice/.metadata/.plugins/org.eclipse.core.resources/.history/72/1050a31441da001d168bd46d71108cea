FROM openjdk:17-alpine
COPY target/eurekaserverimage.jar eurekaserverimage.jar
EXPOSE 1111
ENTRYPOINT ["java","-jar","/eurekaserverimage.jar"]