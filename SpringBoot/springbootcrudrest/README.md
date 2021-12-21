# WHAT WE ARE BUILDING

We are building a simple CRUD User Management Application Rest APIs.

## Tools and Technologies Used
- Spring Boot - 2.0.4.RELEASE
- JDK - 1.8 or later
- Spring Framework - 5.0.8 RELEASE
- Hibernate - 5.2.17.Final
- Maven - 3.2+
- Spring Data JPA - 2.0.10 RELEASE
- IDE - Eclipse or Spring Tool Suite(STS)
- MYSQL - 5.1.47

## Test Using Postman Client
### 1. Create User REST API
HTTP Method: POST
RequestURL: http://localhost:8080/api/v1/users
Request JSON:
```
{
    "firstName": "Ramesh",
    "lastName": "fadatare",
    "emailId": "ramesh@gmail.com",
    "createdBy": "Ramesh",
    "updatedby": "Ramesh"
}
```
### 2. Get User by ID REST API
HTTP Method: GET
Request URL: http://localhost:8080/api/v1/users/2

### 3. Get all users REST API
HTTP Method: GET
Request URL: http://localhost:8080/api/v1/users

### 4. Update User REST API
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/users/5

### 5. Delete User REST API
HTTP Method: DELETE 
Request URL: http://localhost:8080/api/v1/users/2
