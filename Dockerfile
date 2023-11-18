FROM openjdk:11

EXPOSE 8080

ADD build/libs/SpringBoot_HW2_AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]