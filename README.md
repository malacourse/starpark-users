#Starpark User Service
Simple CRUD with Spring Boot and Mongo

##Testing the API using cURL
Get all users:
```sh
$ curl -i -X GET http://localhost:3000/api/v1/users 
```
Get user with _id value of 587ccfedc9e77c0001fb7e72
```sh
$ curl -i -X GET http://localhost:3000/api/v1/user/587ccfedc9e77c0001fb7e72
```
Delete user with _id value of 587ccfedc9e77c0001fb7e72
```sh
$ curl -i -X DELETE http://localhost:3000/api/v1/user/587ccfedc9e77c0001fb7e72
```
Add new user
```sh
$ curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "David Gordon"}' http://localhost:3000/api/v1/user
```
Modify user with _id value of 587ccfedc9e77c0001fb7e72
```sh
$ curl -i -X PUT -H 'Content-Type: application/json' -d '{"name": "Spark Jackson",}' http://localhost:8080/api/v1/user/587ccfedc9e77c0001fb7e72
```

##REST API
URL  | HTTP Verb | POST Body | Result 
------------- | ------------- | ------------- | -------------
/api/v1/users  | GET  | empty  | Return all users
/api/v1/user  | POST   | JSON string  | New user created
/api/v1/user/:id  | GET   | empty  | Return single user
/api/v1/user/:id  | PUT   | JSON string  | Updates an existing user
/api/v1/user/:id  | DELETE   | empty  | Deletes existing keyword
