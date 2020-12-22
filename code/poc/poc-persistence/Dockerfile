FROM openjdk:8-alpine
ADD ./code/poc/poc-persistence/target/persistence-1.0.0.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]