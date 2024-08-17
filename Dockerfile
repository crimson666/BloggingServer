FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/BloggingServer.jar BloggingServer.jar
EXPOSE 5000
CMD ["java","-jar","BloggingServer.jar"]