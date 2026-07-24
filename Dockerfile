# =========================
# Etapa 1: Build
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -B -q dependency:go-offline -DskipTests || true

COPY src ./src
RUN mvn -B -DskipTests package \
    && cp target/msvc_ficohsa_insurance-*.jar /app/application.jar

# =========================
# Etapa 2: Runtime
# =========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S ficohsa && adduser -S ficohsa -G ficohsa

COPY --from=build /app/application.jar /app/application.jar

USER ficohsa

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/application.jar"]
