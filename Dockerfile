FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy project files from WebScrapping folder
COPY WebScrapping/pom.xml .
COPY WebScrapping/src ./src
COPY WebScrapping/mvnw .
COPY WebScrapping/mvnw.cmd .
COPY WebScrapping/.mvn ./.mvn

RUN chmod +x mvnw

# Build the application
RUN ./mvnw -B package

# Run the jar
CMD ["java", "-jar", "target/*.jar"]
