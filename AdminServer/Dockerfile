FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9000
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]