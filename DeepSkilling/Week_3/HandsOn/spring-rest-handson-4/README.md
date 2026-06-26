# Spring REST Hands-on 4

Completed by: Rishabh Dubey

## Project Details

- Application name: `spring-rest-handson-4`
- Package name: `com.cognizant.springlearn`

## Hands-on Covered

### 1. HTTP Method Types

Implemented REST methods according to standard REST usage:

| Method | Purpose |
|---|---|
| GET | Fetch resource data |
| POST | Create resource data |
| PUT | Update resource data |
| DELETE | Delete resource data |

### 2. RESTful URL Naming Guidelines

Country APIs use resource-based naming with class-level mapping:

```java
@RequestMapping("/countries")
```

Employee APIs use:

```java
@RequestMapping("/employees")
```

Department APIs use:

```java
@RequestMapping("/departments")
```

### 3. Country POST Service

Implemented POST API for creating a country.

```http
POST http://localhost:8090/countries
```

Sample JSON:

```json
{
  "code": "IN",
  "name": "India"
}
```

Expected response:

```json
{
  "code": "IN",
  "name": "India"
}
```

### 4. JSON to Bean Mapping

Used `@RequestBody` to map JSON request data into the `Country` bean.

```java
public Country addCountry(@RequestBody @Valid Country country)
```

### 5. Country Validation

Added validation on country code:

```java
@NotNull
@Size(min = 2, max = 2, message = "Country code should be 2 characters")
private String code;
```

Invalid request:

```json
{
  "code": "I",
  "name": "India"
}
```

Expected response status:

```http
400 Bad Request
```

### 6. Global Exception Handler

Created `GlobalExceptionHandler` using:

```java
@ControllerAdvice
```

Handled validation errors globally using `handleMethodArgumentNotValid()`.

Handled incorrect numeric format errors using `handleHttpMessageNotReadable()`.

### 7. Employee Update Service

Implemented PUT API for updating employee data.

```http
PUT http://localhost:8090/employees
```

Sample JSON:

```json
{
  "id": 1,
  "name": "Rishabh Dubey Updated",
  "salary": 90000,
  "permanent": true,
  "dateOfBirth": "14/07/2004",
  "department": {
    "id": 1,
    "name": "Engineering"
  },
  "skillList": [
    {
      "id": 1,
      "name": "Java"
    },
    {
      "id": 3,
      "name": "SQL"
    }
  ]
}
```

Expected response:

```http
200 OK
```

Verify update:

```http
GET http://localhost:8090/employees
```

### 8. Employee Delete Service

Implemented DELETE API for deleting employee by id.

```http
DELETE http://localhost:8090/employees/1
```

Expected response:

```http
200 OK
```

Verify deletion:

```http
GET http://localhost:8090/employees
```

### 9. Employee Not Found Exception

Created `EmployeeNotFoundException` with:

```java
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee not found")
```

Invalid update/delete returns:

```http
404 Not Found
```

### 10. MockMvc Tests

Created MockMvc tests for:

- Application context loading
- Country validation error
- Employee update exceptional scenario
- Employee delete exceptional scenario

Run tests:

```bash
mvn clean test
```

## Postman URLs

### Country APIs

```http
GET http://localhost:8090/countries
```

```http
GET http://localhost:8090/countries/IN
```

```http
POST http://localhost:8090/countries
```

### Employee APIs

```http
GET http://localhost:8090/employees
```

```http
PUT http://localhost:8090/employees
```

```http
DELETE http://localhost:8090/employees/1
```

### Department API

```http
GET http://localhost:8090/departments
```

## Curl Commands

### POST Country

```bash
curl -i -H "Content-Type: application/json" -X POST -s -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
```

### POST Country Validation Error

```bash
curl -i -H "Content-Type: application/json" -X POST -s -d '{"code":"I","name":"India"}' http://localhost:8090/countries
```

### PUT Employee

```bash
curl -i -H "Content-Type: application/json" -X PUT -s -d '{"id":1,"name":"Rishabh Dubey Updated","salary":90000,"permanent":true,"dateOfBirth":"14/07/2004","department":{"id":1,"name":"Engineering"},"skillList":[{"id":1,"name":"Java"}]}' http://localhost:8090/employees
```

### DELETE Employee

```bash
curl -i -X DELETE -s http://localhost:8090/employees/1
```