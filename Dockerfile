FROM quay.io/aibrahim/ubi8-minimal-java-11:latest
MAINTAINER Aly Ibrahim<aly.ibrahim@gmail.com>
ADD http://nexus-openshift-operators.apps.cluster-25l4w.25l4w.sandbox1575.opentlc.com/repository/maven-snapshots/com/aliction/animals-counter-springboot/0.0.1-SNAPSHOT/animals-counter-springboot-0.0.1-20220324.204441-1.jar /deployments/
#ADD animals-counter-springboot/target/animals-counter-springboot-0.0.1-SNAPSHOT.jar /deployments/application.jar
#RUN chmod +x /deployments/application.jar
RUN chgrp -R 0 /deployments/ && chmod -R g=u /deployments
WORKDIR /deployments/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "animals-counter-springboot-0.0.1-20220324.204441-1.jar"]
#ENTRYPOINT ["java", "-jar", "application.jar", "-Dspring.config.additional-location=config/application.properties"]
