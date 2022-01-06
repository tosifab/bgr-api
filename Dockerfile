FROM openjdk:17
COPY build/libs/bgr-api-all.jar app/bgr-api.jar
CMD ["java", "-jar", "app/bgr-api.jar"]