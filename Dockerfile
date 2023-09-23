FROM openjdk:17
ADD target/employeemanagementsystem-0.0.1-SNAPSHOT.jar employeemanagementsystem.jar
ENTRYPOINT ["java", "-jar", "employeemanagementsystem.jar"]



