# Customer-app

## Prerequisites:
Java version : 17

## Set-up
1. Clone the repository: ```git clone git@github.com:KannegundlaPrerana/customer-app.git```
2. Move to directory: ```cd customer-app```

## Commands
1. ```./gradlew build```   : Builds the project.
2. ```./gradlew test```    : Triggers tests.
3. ```./gradlew bootRun``` : Starts the application on 8080 port with in memory H2 Database.

## API
Below are list of API endpoints with their respective input and outputs.

### Add Customer
Endpoint: ```POST /customer/add-customer```

Example of request body
```json
    {
        "firstName": "firstName10",
        "lastName": "name",
        "dateOfBirth": "2018-10-01"
    }
```
Response: CustomerId of added customer.

Open endpoint: ```localhost:8080/h2-console``` to check the in memory H2-database data.

### Get Customer
Endpoint: ```GET /customer/get-customer/<customerId>```

Response: Customer details of customer with given customerId.

Example of response body: 
```json
    {
        "id": 1,
        "firstName": "firstName10",
        "lastName": "name",
        "dateOfBirth": "2020-10-01"
    }
```



