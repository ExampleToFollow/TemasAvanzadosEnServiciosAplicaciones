FROM openjdk:23-ea-17-jdk
EXPOSE 8080
ADD ./target/ProyectoTemasAvanzados-0.0.1-SNAPSHOT.jar proyecto.jar
ENTRYPOINT ["java", "-jar", "proyecto.jar"]