FROM openjdk:17-alpine
COPY target/transactionserviceimage.jar transactionserviceimage.jar
EXPOSE 4444
ENTRYPOINT ["java","-jar","/transactionserviceimage.jar"]