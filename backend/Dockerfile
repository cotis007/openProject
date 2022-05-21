FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=impl/target/impl-1.0-SNAPSHOT.war
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev" , "-jar",  "application.jar"]
EXPOSE 8082