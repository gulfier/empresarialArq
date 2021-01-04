FROM openjdk:8-alpine
ADD ./code/poc/poc-web/target/web-1.0.0.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]