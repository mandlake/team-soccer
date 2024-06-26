#Window
FROM gradle:8.7.0-jdk17-alpine AS builder
COPY --chown=gradle:gradle . /gradle/
WORKDIR /gradle
RUN gradle build --no-daemon
FROM openjdk:17-alpine
RUN mkdir /app
COPY --from=builder /gradle/build/libs/*.jar /app/app.jar
ARG PROFILE
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

 # Mac
#FROM arm64v8/gradle:8.7.0-jdk17 AS builder
#COPY --chown=gradle:gradle . /gradle/
#WORKDIR /gradle
#RUN gradle build --no-daemon
#
#FROM arm64v8/openjdk:17
#RUN mkdir /app
#COPY --from=builder /gradle/build/libs/*.jar /app/app.jar
#ARG PROFILE
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]