# Cinema Room REST Service

A RESTful Java Spring Boot service for managing purchase and refund of cinema tickets.
As configured, the service define a cinema room of 9 rows and 9 columns of seats, which make
up 81 seats in total. The service can be operated with the following HTTP requests.

- GET /seats
  - This request return the properties of cinema room, namely the number of rows, number of columns,
  and the list of seats
  - The seats are defined by their row, column, and price
  - Response body:
    ```
    {
        "columns": 9,
        "rows": 9,
        "seats": [
            {
                "row": 1,
                "column": 1,
                "price": 10
            },
            {
                "row": 1,
                "column": 2,
                "price": 10
            },
            ...
            {
                "row": 9,
                "column": 8,
                "price": 8
            },
            {
                "row": 9,
                "column": 9,
                "price": 8
            }
        ]
      }
    ```
- POST /purchase
  - A seat can be purchased by sending a valid request body
  - When successful, this returns the seat purchased, along with a unique token as its identifier
  - On the other hand, this will throw an error if:
    - the seat is already purchased
    - the requested row or column exceeds the cinema's
  - Sample valid request body:
    ```
    {
        "row": 3,
        "column": 4
    }
    ```
  - Sample successful purchase response:
    ``` 
    {
        "token": "f589108b-d237-4d9a-823f-aa02c4937672",
        "ticket": {
            "row": 3,
            "column": 4,
            "price": 10
    }
    ```
  - Sample errors
    ```
    {
        "error": "The number of a row or a column is out of bounds!"
    }
    ```
    ```
    {
        "error": "The ticket has been already purchased!"
    }
    ```
- POST /return
  - A seat can be refunded using a valid token, i.e. it not yet used
  - When successful, this returns the seat refunded
  - On the other hand, this will throw an error if the token is invalid
  - Sample valid request body:
    ```
    {
        "token": "f589108b-d237-4d9a-823f-aa02c4937672"
    }
    ```
  - Sample successful refund response:
    ```
    {
        "ticket": {
            "row": 3,
            "column": 4,
            "price": 10
    }
    ```
  - Sample error
    ```
    {
        "error": "Wrong token!"
    }
    ```
- GET /stats
  - Given a valid password as its request parameter, this returns the statistics for the following:
  income, available seats, purchased seats of the cinema
  - On the other hand, this will throw an error if sent with empty or invalid password
  - Sample valid request
    ```
    GET /stats?password=*****
    ```
  - Sample successful response
    ```
    {
        "income": 18,
        "available": 79,
        "purchased": 2 
    }
    ```
  - Sample error
    ```
    {
        "error": "The password is wrong!"
    }
    ```
