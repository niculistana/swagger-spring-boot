# Swagger Spring Boot
Integrates swagger docs to spring boot application.

### Dependencies
- Swagger 2.0 spec via `springfox-swagger-ui`
- MySql via `mysql-connector-java`
- REST via `spring-boot-started-web` and `spring-boot-starter-data-jpa`

### Database commands
After cloning:
```
$> mysql -u root -p # then enter your password
mysql> create database db-example;
mysql> create user 'springuser'@'localhost' identified by 'ThePassword';
mysql> grant all on db_example.* to 'springuser'@'localhost';
```

Secure the app, by running these commands after your first build:
```
mysql> revoke all on db_example.* from 'springuser'@'localhost';
mysql> grant select, insert, delete, update on db_example.* to 'springuser'@'localhost';
```
See [here](https://spring.io/guides/gs/accessing-data-mysql/) for more info.

### Console commands
```
mvn install -- installs dependencies
mvn clean package -- cleans the /target folder and packages the jar
mvn spring-boot:run -- runs the built-in tomcat server

open http://localhost:8080/swagger-ui.html -- opens swagger docs in your browser
```
See [here](http://springfox.github.io/springfox/docs/current/) for more info.