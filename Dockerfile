
#
# Build stage
#
FROM gradle:jdk20-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="PettyPantry"
#
# Package stage
#
FROM eclipse-temurin:20-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/pettypantry-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]