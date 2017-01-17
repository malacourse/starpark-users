#Starpark User Service
Simple CRUD with Spring Boot and Mongo

##Externalize Configuration with OpenShift

Create the ConfigMap object
```sh
oc create configmap users --from-file=src/main/resources/application.properties 
```

Create a volume the points to the ConfigMap in the deployment configuration
```yaml
    spec:
      volumes:
        -
          name: config
          configMap:
            name: users
            items:
              - {key: application.properties, path: application.properties}
      containers:
        -
```

Mount the volume to the application container in the deployment configuration
```yaml
      containers:
        -
          volumeMounts:
            -
              name: config
              mountPath: /deployments/config
```

Edit the ConfigMap and insert appropriate values for the environment
```sh
oc edit configmap users
```

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
