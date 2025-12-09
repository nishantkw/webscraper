# -----------------------------
# Stage 1: Build the Application
# -----------------------------
FROM maven:3.9.6-amazoncorretto-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the JAR file
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Run the Application
# -----------------------------
FROM amazoncorretto:17-alpine

WORKDIR /app

# Copy the jar file from previous stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Run the spring boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
