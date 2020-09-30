# Appointment-api

Simple appointment scheduling software

  - Register Doctor
  - Register Appointment
  - Listing Doctors
  - Listing Appointments
  
 ### Installation


To build the project first [create a mysql database instance in google cloud](https://cloud.google.com/sql/docs/mysql/create-instance?hl=pt-br).

Use Gradle to install the project dependencies. Generate the access key for mysql google cloud and configure the directory in the spring.cloud.gcp.credentials.location property in application.properties.
```
spring.cloud.gcp.credentials.location=file:/
```
Configure the other properties required for accessing mysql in the Google cloud
```
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://[ip-data-base]/[name-instance-data-base]
spring.datasource.username=[user]
spring.datasource.password=[password]
```

### Tech

Technologies used

* [Java] - Version 1.8
* [Spring Boot] - Version 2.3.3.RELEASE
* [Gradle] - Manager used 
* [Google Cloud - MySql] - Database used

License
----

Software free