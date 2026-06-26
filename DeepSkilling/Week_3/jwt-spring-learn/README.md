# JWT Hands-on

**Done by:** Rishabh Dubey  
**Package:** `com.cognizant.springlearn`  
**Application:** `jwt-spring-learn`

This project implements the JWT authentication hands-on using Spring Boot 3, Spring Security, Lombok, Spring Web, DevTools, and JJWT.

## Hands-on Covered

1. Securing RESTful web services with Spring Security
2. Creating users and roles in Spring Security
3. Understanding Basic Authentication limitations
4. Creating authentication service that returns JWT
5. Reading and decoding the Authorization header
6. Generating JWT token
7. Authorizing API requests using JWT Bearer token
8. Securing `/countries` API using JWT filter

## Important Screenshot Paths

Place your screenshots in the `screenshots` folder using these names.

```text
screenshots/
├── 01-project-structure.png
├── 02-application-startup.png
├── 03-basic-auth-unauthorized.png
├── 04-basic-auth-user-success.png
├── 05-basic-auth-admin-forbidden.png
├── 06-authenticate-api-basic-auth.png
├── 07-generated-jwt-token.png
├── 08-jwt-token-decoded-jwt-io.png
├── 09-bearer-token-countries-success.png
├── 10-invalid-token-unauthorized.png
├── 11-security-config-code.png
├── 12-authentication-controller-code.png
├── 13-jwt-authorization-filter-code.png
└── 14-final-output.png
```

## Screenshots

### Project Structure
![Project Structure](screenshots/01-project-structure.png)

### Application Startup
![Application Startup](screenshots/02-application-startup.png)

### Basic Auth Unauthorized
![Basic Auth Unauthorized](screenshots/03-basic-auth-unauthorized.png)

### Basic Auth USER Success
![Basic Auth USER Success](screenshots/04-basic-auth-user-success.png)

### Basic Auth ADMIN Forbidden
![Basic Auth ADMIN Forbidden](screenshots/05-basic-auth-admin-forbidden.png)

### Authenticate API with Basic Auth
![Authenticate API](screenshots/06-authenticate-api-basic-auth.png)

### Generated JWT Token
![Generated JWT Token](screenshots/07-generated-jwt-token.png)

### JWT Token Decoded on jwt.io
![JWT Decoded](screenshots/08-jwt-token-decoded-jwt-io.png)

### Countries API with Bearer Token
![Bearer Token Success](screenshots/09-bearer-token-countries-success.png)

### Invalid Token Unauthorized
![Invalid Token](screenshots/10-invalid-token-unauthorized.png)

### SecurityConfig Code
![SecurityConfig](screenshots/11-security-config-code.png)

### AuthenticationController Code
![AuthenticationController](screenshots/12-authentication-controller-code.png)

### JwtAuthorizationFilter Code
![JwtAuthorizationFilter](screenshots/13-jwt-authorization-filter-code.png)

### Final Output
![Final Output](screenshots/14-final-output.png)

## Run Application

```bash
mvn clean spring-boot:run
```

Application runs on:

```text
http://localhost:8090
```

## Users

| Username | Password | Role |
|---|---|---|
| `user` | `pwd` | `USER` |
| `admin` | `pwd` | `ADMIN` |

## Test APIs

### 1. Try Protected API Without Authentication

```bash
curl -s http://localhost:8090/countries
```

Expected:

```json
{
  "status": 401,
  "error": "Unauthorized"
}
```

### 2. Generate JWT Token

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

Expected:

```json
{
  "token": "GENERATED_JWT_TOKEN"
}
```

### 3. Access Countries API with JWT

```bash
curl -s -H "Authorization: Bearer REPLACE_TOKEN_HERE" http://localhost:8090/countries
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

### 4. Test Invalid JWT

```bash
curl -s -H "Authorization: Bearer invalid-token" http://localhost:8090/countries
```

Expected:

```json
{
  "status": 401,
  "error": "Unauthorized"
}
```

## Postman Testing

### Generate Token

Method:

```text
GET
```

URL:

```text
http://localhost:8090/authenticate
```

Authorization:

```text
Basic Auth
Username: user
Password: pwd
```

### Access Countries

Method:

```text
GET
```

URL:

```text
http://localhost:8090/countries
```

Authorization:

```text
Bearer Token
Token: paste generated JWT token
```
