# JWT Hands-on

Completed by: Rishabh Dubey
**Package:** `com.cognizant.springlearn`
**Application:** `jwt-spring-learn`

This project implements the JWT authentication hands-on using Spring Boot 3, Spring Security, Lombok, Spring Web, DevTools, and JJWT.

---

# Hands-on Covered

1. Securing RESTful web services with Spring Security
2. Creating users and roles in Spring Security
3. Understanding Basic Authentication limitations
4. Creating authentication service that returns JWT
5. Reading and decoding the Authorization header
6. Generating JWT token
7. Authorizing API requests using JWT Bearer token
8. Securing `/countries` API using JWT filter

---

# Screenshots

## Project Structure

![Project Structure](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_8.png)

---

## Spring Boot Startup

![Application Startup](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_13.png)

---

## Access Protected API Without Authentication (401 Unauthorized)

**GET**

```text
http://localhost:8090/countries
```

![Unauthorized](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_1.png)

---

## Access Countries using USER Credentials

**GET**

```text
http://localhost:8090/countries
```

Authorization:

```text
Basic Auth

Username : user
Password : pwd
```

![USER Access](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_2.png)

---

## Access Countries using ADMIN Credentials

**GET**

```text
http://localhost:8090/countries
```

Authorization:

```text
Basic Auth

Username : admin
Password : pwd
```

Expected:

```text
403 Forbidden
```

![ADMIN Forbidden](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_3.png)

---

## Generate JWT Token

**GET**

```text
http://localhost:8090/authenticate
```

Authorization:

```text
Basic Auth

Username : user
Password : pwd
```

Expected Response

```json
{
  "token": "GENERATED_JWT_TOKEN"
}
```

![Generated JWT](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_4.png)

---

## Decode JWT Token using jwt.io

Open:

```text
https://jwt.io
```

Paste the generated JWT token.

![JWT Decoded](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_5.png)

---

## Access Countries using JWT Bearer Token

**GET**

```text
http://localhost:8090/countries
```

Authorization:

```text
Bearer Token

<Generated JWT Token>
```

![Bearer Token Success](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_6.png)

---

## Invalid JWT

**GET**

```text
http://localhost:8090/countries
```

Authorization:

```text
Bearer Token

invalid-token
```

Expected:

```text
401 Unauthorized
```

![Invalid JWT](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_7.png)

---

## SecurityConfig.java

![SecurityConfig](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_9.png)

---

## AuthenticationController.java

![AuthenticationController](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_10.png)

---

## JwtAuthorizationFilter.java

![JwtAuthorizationFilter](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_11.png)

---

## JwtUtil.java

![JwtUtil](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_12.png)

---

## Final Output

![Final Output](https://raw.githubusercontent.com/RishBootDev/Cognizant_DN/main/DeepSkilling/Week_3/postman_output/handson_jwt_14.png)

---

# Run Application

```bash
mvn clean spring-boot:run
```

Application runs on:

```text
http://localhost:8090
```

---

# Users

| Username | Password | Role    |
| -------- | -------- | ------- |
| `user`   | `pwd`    | `USER`  |
| `admin`  | `pwd`    | `ADMIN` |

---

# Test APIs

## 1. Try Protected API Without Authentication

```http
GET http://localhost:8090/countries
```

Expected:

```json
{
  "status": 401,
  "error": "Unauthorized"
}
```

---

## 2. Generate JWT Token

```http
GET http://localhost:8090/authenticate
```

Authorization:

```text
Basic Auth

Username : user
Password : pwd
```

Expected:

```json
{
  "token": "GENERATED_JWT_TOKEN"
}
```

---

## 3. Access Countries API with JWT

```http
GET http://localhost:8090/countries
```

Authorization:

```text
Bearer Token

<Generated JWT Token>
```

Expected:

```json
[
  {
    "code": "US",
    "name": "United States"
  },
  {
    "code": "DE",
    "name": "Germany"
  },
  {
    "code": "IN",
    "name": "India"
  },
  {
    "code": "JP",
    "name": "Japan"
  }
]
```

---

## 4. Test Invalid JWT

```http
GET http://localhost:8090/countries
```

Authorization:

```text
Bearer Token

invalid-token
```

Expected:

```json
{
  "status": 401,
  "error": "Unauthorized"
}
```
