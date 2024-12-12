FROM maven:3-eclipse-temurin-22 AS build
LABEL authors="stevenoliveira"

COPY . .

RUN mvn clean package -DskipTests

FROM maven:3-eclipse-temurin-22-alpine

COPY --from=build /target/fitness-journey-backend-atividade-1.0.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]