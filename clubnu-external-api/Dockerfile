# Use OpenJDK 17 with Alpine for a smaller image
FROM openjdk:17-alpine

# Set a build argument for the JAR file (you can specify this when building the image)
ARG JAR_FILE=build/libs/*.jar

# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Use shell form for ENTRYPOINT to handle environment variable substitution
ENTRYPOINT java -jar /app.jar --spring.profiles.active=prod
