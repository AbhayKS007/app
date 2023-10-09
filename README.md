# GuestService 

# SpringBoot JPA MySQL

### 1. You can clone it from github by running following command

```
  $ git clone https://github.com/AbhayKS007/app.git
```

### 2. Import project into eclipse
```
  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
```
### 3. Right click on project in eclipse and then Maven -> Update Projects 

### 4. Import src/main/java/resources/book.sql into MySQL database

### 5. Update database credential and other configuration into application.properties available in src/main/java/resources

```

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=root
spring.datasource.password=
spring.datasource.tomcat.max-wait=20000
spring.datasource.tomcat.max-active=50
spring.datasource.tomcat.max-idle=20
spring.datasource.tomcat.min-idle=15

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.id.new_generator_mappings = false
spring.jpa.properties.hibernate.format_sql = true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE


```
### 6. Right click on Application.java file and run as Java Application

## Once Sprint Boot Application will be started successfully then we 
can call following Endpoints by using POSTMAN

### 7. To get list of guest following endpoint with GET Request
```
  http://localhost:8082/bookservice/admin
  add params:
	role: admin
	pass: pass
```
### 8.To add new Guest following url with POST Request
```
http://localhost:8082/bookservice/guest
```
### set content type as in header as `application/json`
### set request body as raw with JSON payload
### add param:
	role: guest
```
  {
    "des": "Text"
  }

```
### 9.To get a particular guest, use following url with `GET` request type in postman
```
   http://localhost:8082/bookservice/admin/<id>
```

```
### 11.To update approval 
 ### use param:
	value: yes/no
```
  http://localhost:8082/bookservice/admin/<id>
```

### Note - Replace <id> with actual id 
