FROM openjdk:17-alpine
COPY target/gatewayapiimage.jar gatewayapiimage.jar
EXPOSE 5555
ENTRYPOINT ["java","-jar","/gatewayapiimage.jar"]
