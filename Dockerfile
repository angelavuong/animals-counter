FROM quay.io/aibrahim/ubi8-minimal-java-11:latest
MAINTAINER Aly Ibrahim<aly.ibrahim@gmail.com>
ADD http://nexus-openshift-operators.apps.cluster-5c55.5c55.sandbox909.opentlc.com/repository/maven-snapshots/com/aliction/animals-counter-springboot/0.0.1-SNAPSHOT/animals-counter-springboot-0.0.1-20220211.172859-1.jar /deployments/application.jar 
#ADD animals-counter-springboot/target/animals-counter-springboot-0.0.1-SNAPSHOT.jar /deployments/application.jar
WORKDIR /deployments
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
#ENTRYPOINT ["java", "-jar", "application.jar", "-Dspring.config.additional-location=config/application.properties"]
