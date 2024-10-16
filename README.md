## Technologies 
- Spring Boot (v3.3.1)
- Spring Data JPA
- Spring Validation
- Spring Security + JWT Token
- PostgreSQL
- Mapstruct
- Lombok
- Swagger (Open API)

## Customization

- You can customize ```token information (secret key, issuer, expiry date) ``` in application.yml file.
- You can customize ```database connection information``` in application.yml file.
- You can customize ```swagger information``` in application.yml file.
- You can customize ```which endpoints are accessible without token information``` in SecurityConfiguration.java file.

## Run the Application

First you need to make sure that the database is up. 
If you're using Docker, you can use ```docker compose up -d``` command. (If you have made changes in local, you should use the *local-docker-compose* file.)

Navigate to the root of the project. For building the project using command line, run below command :

``` mvn clean install```

Run service in command line. Navigate to *target* directory. 

``` java -jar desa-canggih.jar ```
