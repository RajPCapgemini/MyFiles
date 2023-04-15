FROM openjdk:17-alpine
COPY target/adminserverimage.jar adminserverimage.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/adminserverimage.jar"]