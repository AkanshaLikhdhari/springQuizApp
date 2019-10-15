# Welcome to the springQuizApp project!

This application is being developed as a Spring Boot project.

The idea of the application is simple, it's a quiz application in which users can play a quiz.
The application includes a simple but functional web frontend using Angular 8 and Bootstrap.

## Getting Started

All the code required to run this project is available in this Git repository. You can either download it as a zip file from Github or run:

```bash
$ git clone https:// https://github.com/AkanshaLikhdhari/quizFrontEnd.git
$ git clone https:// https://github.com/AkanshaLikhdhari/springQuizApp.git

```

### Environment

In order to run springQuizApp you will need:

* [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Main Backend Language
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://www.mysql.com) - RDBMS.

In addition, there are a few optional yet recommended installations:

* [Git](https://git-scm.com)
* IDE- IntelliJ

### Prerequisites

#### Database Setup

Before starting the application, you will need to set up the database. By default, springQuizApp attempts to connect to a in-memory database called H2 which is default set as active profile in application.properties.
If you don't wish to use in-memory db you can use mysql with database name quizapp by changing you active profile in application.properties to mysql.

### Time to run the application!

You can run the application either using maven on the command line or using your IDE to import and run the code. 

#### Using Maven

If you don't want to go through the process of using an IDE and just want to get the project running to explore it, navigate to the directory where you downloaded the source code and run:

```bash
$ mvn spring-boot:run
```

If everything went well, you should be able to access the web app here: http://localhost:8083