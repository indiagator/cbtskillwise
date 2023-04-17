FROM amazoncorretto:17.0.6-al2023
MAINTAINER indiagator
COPY target/cbtskillwise-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/app.jar"]