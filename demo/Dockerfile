FROM amazoncorretto:17
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_=target/*.jar 
COPY ./build/libs/*.jar app.jar 
ENTRYPOINT ["java", "-jar", "app.jar"]