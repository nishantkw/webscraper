FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY WebScrapping/pom.xml .
COPY WebScrapping/mvnw .
COPY WebScrapping/mvnw.cmd .
COPY WebScrapping/.mvn ./.mvn
COPY WebScrapping/src ./src

RUN chmod +x mvnw

RUN ./mvnw -B package -DskipTests

CMD ["sh", "-c", "java -jar target/*.jar"]
