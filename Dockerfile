# Use Maven with Java 17 to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the Spring Boot jar
RUN mvn clean package -DskipTests


# Use a lightweight Java runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the generated jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
