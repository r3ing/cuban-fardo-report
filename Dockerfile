
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:11-jre-slim
WORKDIR /app
COPY - from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]


#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8080
