# java-textbook
Basic functionality for Java development

## Using Gradle to run whole project
In project root folder (where are _build.gradle_ and _settings.gradle_ files)  
``` gradle run --args "myFirstArgument mySecondArgument"```
* "myFirstArgument mySecondArgument" - arguments you want to pass into _main(String args[])_, will be accessible as 
args[0], args[1].

## Connecting to Postgres database
1. You need to download postgresql-42.2.10 or later libary
2. Place it under project root
3. Using ``` File -> Project Structure -> Modules``` in InteliJ, add it to current project.
4. If you want to add it to gradle build also add this line to build.gradle  
``` compile(group: 'org.postgresql', name: 'postgresql', version: '42.2.10')```
5. For connection, I have created separate class

# Spring Framework
STEP 1. [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) - setting up hello-world endpoint. Can be run using ```> mvn spring-boot:run``` 
STEP 2. [Spring Boot + Swagger2](https://www.javainuse.com/spring/boot_swagger) - adding Swagger documentation manager to your Api

