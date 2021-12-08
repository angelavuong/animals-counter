FROM quay.io/aibrahim/ubi8-minimal-java-11:latest
MAINTAINER Aly Ibrahim<aly.ibrahim@gmail.com>
ADD animals-counter-springboot/target/animals-counter-springboot-0.0.1-SNAPSHOT.jar /deployments/application.jar
WORKDIR /deployments
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
#ENTRYPOINT ["java", "-jar", "application.jar", "-Dspring.config.additional-location=config/application.properties"]
