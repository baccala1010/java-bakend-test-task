FROM openjdk:17
ARG jarFile=build/libs/java-bakend-test-task-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${jarFile} sensorsapp.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "sensorsapp.jar"]