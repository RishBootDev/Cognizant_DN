# JWT Authentication Hands-on

Completed by: Rishabh Dubey

# Exercise 1 – Securing RESTful Web Services

Added Spring Security dependency and secured all REST endpoints.

### Test Command

```bash
curl -s http://localhost:8090/countries
```

### Expected Response (As specified in the Hands-on)

```json
{
  "timestamp":"2019-10-05T09:24:33.794+0000",
  "status":401,
  "error":"Unauthorized",
  "message":"Unauthorized",
  "path":"/countries"
}
```

### Screenshot

[View Screenshot](screenshots/01-unauthorized-response.png)

---

# Exercise 2 – Access Using Generated Password

Executed:

```bash
curl -s -v -u user:<generated-password> http://localhost:8090/countries
```

Verified:

* Countries are returned successfully.
* Authorization header contains Base64 encoded credentials.

### Screenshots

* [Generated Password](screenshots/02-generated-password.png)
* [Basic Authentication Success](screenshots/03-basic-auth-success.png)

---

# Exercise 3 – Creating Users and Roles

Configured two in-memory users.

| Username | Password | Role  |
| -------- | -------- | ----- |
| admin    | pwd      | ADMIN |
| user     | pwd      | USER  |

Configured `/countries` to be accessible only by **USER** role.

---

## Correct Credentials

```bash
curl -s -u user:pwd http://localhost:8090/countries
```

### Screenshot

[View Screenshot](screenshots/04-user-role-success.png)

---

## Incorrect Password

```bash
curl -s -u user:pwd1 http://localhost:8090/countries
```

### Expected Response (As specified in the Hands-on)

```json
{
  "timestamp":"2019-10-05T10:19:08.237+0000",
  "status":401,
  "error":"Unauthorized",
  "message":"Unauthorized",
  "path":"/countries"
}
```

### Screenshot

[View Screenshot](screenshots/05-invalid-password.png)

---

## Correct Credentials but Wrong Role

```bash
curl -s -u admin:pwd http://localhost:8090/countries
```

### Expected Response (As specified in the Hands-on)

```json
{
  "timestamp":"2019-10-05T10:22:38.015+0000",
  "status":403,
  "error":"Forbidden",
  "message":"Forbidden",
  "path":"/countries"
}
```

### Screenshot

[View Screenshot](screenshots/06-admin-forbidden.png)

---

# Exercise 4 – Base64 Authorization Header

Verified that the Authorization header contains Base64 encoded credentials.

Decoded using:

https://www.base64decode.net/

### Screenshot

[View Screenshot](screenshots/07-base64-decode.png)

---

# Exercise 5 – Understanding JWT

Verified JWT structure using:

* https://jwt.io/
* Wikipedia JWT Structure

Verified the generated token contains:

* Header
* Payload
* Signature

### Screenshot

[View Screenshot](screenshots/08-jwt-structure.png)

---

# Exercise 6 – Authentication Service

Implemented:

```http
GET /authenticate
```

### Test Command

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

### Expected Response (As specified in the Hands-on)

```json
{
  "token":"<generated-jwt-token>"
}
```

### Screenshots

* [Authenticate API](screenshots/09-authenticate-api.png)
* [Generated JWT Token](screenshots/10-generated-token.png)

---

# Exercise 7 – Authorization Header Logging

Verified that the Authorization header starts with:

```
Basic
```

and contains Base64 encoded credentials.

### Screenshot

[View Screenshot](screenshots/11-authorization-header-log.png)

---

# Exercise 8 – JWT Generation

Generated JWT using JJWT.

Verified:

* Subject
* Issued Time
* Expiration Time
* Signature

### Screenshot

[View Screenshot](screenshots/12-jwt-generated.png)

---

# Exercise 9 – JWT Authorization Filter

Implemented:

* JwtAuthorizationFilter
* Bearer Token Validation
* SecurityContext Authentication

### Screenshot

[View Screenshot](screenshots/13-jwt-filter.png)

---

# Exercise 10 – Access Protected API using JWT

Generate token:

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

Invoke protected API:

```bash
curl -s -H "Authorization: Bearer REPLACE_TOKEN_HERE" http://localhost:8090/countries
```

Verified that the countries are returned successfully.

### Screenshot

[View Screenshot](screenshots/14-jwt-protected-api.png)

---

# Exercise 11 – Invalid JWT

Modified the generated JWT token.

Executed:

```bash
curl -s -H "Authorization: Bearer INVALID_TOKEN" http://localhost:8090/countries
```

Verified Unauthorized response.

### Screenshot

[View Screenshot](screenshots/15-invalid-jwt.png)

---

# Important APIs

## Get Countries

```http
GET http://localhost:8090/countries
```

## Authenticate User

```http
GET http://localhost:8090/authenticate
```

---

# Postman Testing

## 1. Basic Authentication

```
GET http://localhost:8090/countries
```

Username

```
user
```

Password

```
pwd
```

Screenshot

[View Screenshot](screenshots/16-postman-basic-auth.png)

---

## 2. Authenticate API

```
GET http://localhost:8090/authenticate
```

Authorization

```
Basic Authentication

Username : user
Password : pwd
```

Screenshot

[View Screenshot](screenshots/17-postman-authenticate.png)

---

## 3. JWT Authorization

```
GET http://localhost:8090/countries
```

Header

```
Authorization: Bearer <JWT_TOKEN>
```

Screenshot

[View Screenshot](screenshots/18-postman-bearer-token.png)

