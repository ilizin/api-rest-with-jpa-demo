# api-rest-with-jpa-demo

This demo project shows how easy is to build an api rest with a jpa persistence layer with springboot and the h2 in memory database.

Springboot is full of properties and annotations, find this code fully commented to document how to use a bunch of them.

**Annotations:** @Repository, @SpringBootApplication, @Service, @Transactional, @RestController, @RequestMapping,
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PathVariable, @RequestBody, @ControllerAdvice, @ExceptionHandler, 

**Properties:** spring.application.name, server.servlet.context-path, spring.datasource.url, spring.datasource.username,
spring.datasource.password, spring.jpa.hibernate.ddl-auto, management.endpoints.web.exposure.include, spring.data.rest.base-path,
spring.data.rest.default-page-size

This demo project goal is just didactic, so I encourage you to read the code, read all the comments, and learn from it.

## Description

This demo project set up an easy API with two controllers and the whole set of CRUD operations each:

* Advertiser controller
    * GET /api/v1/advertisers
    * GET /api/v1/advertiser/{advertiserId}
    * POST /api/v1/advertiser
    * PUT /api/v1/advertiser/{advertiserId}
    * DELETE /api/v1/advertiser/{advertiserId}
* Property controller
    * GET /api/v1/properties
    * GET /api/v1/property/{propertyId}
    * POST /api/v1/property
    * PUT /api/v1/property/{propertyId}
    * DELETE /api/v1/property/{propertyId}

## Installation

1. The project is based on spring boot <i>v3.4.1</i>, so make sure you have installed at least the required *jdk17*:
```
ilizin@ilizin:~$ java -version
openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-86)
OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
ilizin@ilizin:~$ 
```

2. Make sure you've installed the apache maven, or refer to the official page [Install Maven](https://maven.apache.org/install.html)
   to install it.
```
ilizin@ilizin /c
$ mvn -v
Apache Maven 3.9.10 (5f519b97e944483d878815739f519b2eade0a91d)
Maven home: C:\apache-maven-3.9.10
Java version: 17.0.2, vendor: Oracle Corporation, runtime: C:\java\jdk-17.0.2
Default locale: es_ES, platform encoding: Cp1252
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
ilizin@ilizin /c
```

3. Clone the repository:
```
git clone git@github.com:ilizin/api-rest-with-jpa-demo.git
```

4. Run the <i>mvn clean install</i> command to run the tests and install the project:
```
ilizin@ilizin:~/repos/api-rest-with-jpa-demo (main)
$ mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] ----------< org.springframework.boot:api-rest-with-jpa-demo >-----------
[INFO] Building api-rest-with-jpa-demo 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
...
est method 'PUT' is not supported]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.707 s -- in me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest.AdvertisementRestControllerTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.4.2:jar (default-jar) @ api-rest-with-jpa-demo ---
[INFO] Building jar: C:\ilio\repos\api-rest-with-jpa-demo\target\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot:3.4.1:repackage (repackage) @ api-rest-with-jpa-demo ---
[INFO] Replacing main artifact C:\ilio\repos\api-rest-with-jpa-demo\target\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to C:\ilio\repos\api-rest-with-jpa-demo\target\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.jar.original
[INFO]
[INFO] --- install:3.1.3:install (default-install) @ api-rest-with-jpa-demo ---
[INFO] Installing C:\ilio\repos\api-rest-with-jpa-demo\pom.xml to C:\Users\ilio.zincone\.m2\repository\org\springframework\boot\api-rest-with-jpa-demo\0.0.1-SNAPSHOT\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.pom
[INFO] Installing C:\ilio\repos\api-rest-with-jpa-demo\target\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.jar to C:\Users\ilio.zincone\.m2\repository\org\springframework\boot\api-rest-with-jpa-demo\0.0.1-SNAPSHOT\api-rest-with-jpa-demo-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  46.887 s
[INFO] Finished at: 2025-08-30T19:59:08+02:00
[INFO] ------------------------------------------------------------------------
```

## Usage

1. Have the project installed on your machine, see [Installation](#installation)
2. Run the <i>mvn spring-boot:run</i> command to start it.
3. Validate the console shows a message indicating the project is up and running:
```
ilizin@ilizin:~/repos/api-rest-with-jpa-demo $ mvn spring-boot:run
[INFO] Scanning for projects...
....
2025-08-30T20:01:43.774+02:00  INFO 23412 --- [api-rest-with-jpa-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/api-rest-with-jpa-demo'
2025-08-30T20:01:43.806+02:00  INFO 23412 --- [api-rest-with-jpa-demo] [           main] m.i.s.s.a.ApiRestWithJpaDemoApplication  : Started ApiRestWithJpaDemoApplication in 5.855 seconds (process running for 6.22)
```
4. Access the swagger UI page from the link: http://localhost:8080/api-rest-with-jpa-demo/swagger-ui/index.html

## Structure

It's a maven based project, therefore the structure is standard, more details about the maven project director layout  [here](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

## Contributing

Contributions are welcome! If you have an alternative solution or an improvement to an existing solution, feel free to contribute. Follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature-new-solution).
3. Commit your changes (git commit -m 'Add new solution for problem X').
4. Push to the branch (git push origin feature-new-solution).
5. Open a pull request.

## Contact

GitHub: [ilizin](https://github.com/ilizin)

## References

* Spring documentation. (Unknown). *Testing the Web Layer.* <br/>
  Retrieved from https://spring.io/guides/gs/testing-web
