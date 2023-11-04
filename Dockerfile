FROM openjdk:17-oracle
COPY ./build/libs/wncs-backend-0.0.1-SNAPSHOT.jar wncs.jar
ENTRYPOINT ["java", "-jar","-Xmx512M", "-Dspring.profiles.active=main","wncs.jar"]