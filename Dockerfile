FROM openjdk:17
ADD target/DoctorDetails-3-0.0.1-SNAPSHOT.jar DoctorDetails-3.jar
ENTRYPOINT ["java", "-jar", "/DoctorDetails-3.jar"]