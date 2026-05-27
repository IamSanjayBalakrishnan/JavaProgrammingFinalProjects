Task 2

# FirstRestAPI 
   
This project is a  REST API catalogue built with Spring Boot, which allows users to create, read, update, and delete products (CRUD) through HTTP endpoints, using an H2 in-memory database for storage via Spring Data JPA. It follows a layered architecture (Steriotypes): Controller, Service, Repository, and Mapper. It also includes Swagger UI for interactive API documentation.

Base URL: http://localhost:8080/api/v1/products,
Interactive Swagger Interface: http://localhost:8080/swagger-ui/index.html
 
## Technology used
 
- Java
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA
- H2 In-Memory Database
- Swagger UI (springdoc-openapi)
- Maven


## Step-by-Step Implementation
Step 1 — Project Creation in IntelliJ IDEA

Navigate to File → New → Project → Spring Initializr.
Configure the project metadata (Group, Artifact, Name, etc.).
Add the following dependencies:
Spring Web
Spring Data JPA
H2 Database
Spring Boot DevTools

 open the project in IntelliJ.

Step 2 — Domain Model (Product Class)
This class represents the core entity of the application.

Contains fields: id and name
Includes a constructor that takes the product name
Provides getter and setter methods

The Product object is used throughout the application for data storage and response handling.
Step 3 — Repository Layer (ProductRepository)
The repository is responsible for data persistence (currently using in-memory storage).

Annotated with @Repository
Uses a HashMap<Long, Product> to simulate a database
Maintains a counter for generating unique IDs
Implements a save() method that assigns an ID and stores the entity

This serves as a temporary database solution before integrating.

Step 4 — Data Transfer Objects (DTOs)
ProductRequest
Used to receive data from the client in JSON format.

Contains only the name field
Uses @JsonCreator for proper JSON deserialization

ProductResponse
Used to send data back to the client.

Contains id and name fields

These DTOs help separate the internal domain model from the external API contract.

Step 5 — Mapper (ProductMapper)
The mapper handles object conversions between layers.

Converts ProductRequest → Product
Converts Product → ProductResponse
Annotated with @Component

This class ensures clean separation of concerns and keeps the service layer simple.

Step 6 — Service Layer (ProductService)
This layer contains the business logic of the application.
Main responsibilities:

Receive ProductRequest from the controller
Map it to a Product entity
Save the entity through the repository
Convert the saved entity back to ProductResponse
Return the response

Annotated with @Service.
Step 7 — Controller Layer (ProductController)
The controller handles HTTP requests and responses.

Annotated with @RestController
Uses constructor injection for ProductService
Exposes a POST endpoint at /api/v1/products

## How to Run
 
1. Open the project in IntelliJ IDEA
2. Right-click the project → Maven → Reload Project
3. Run FirstRestApiSpringApplication.java
4. Use the URLs. (Given on the Begining of the file)


 ---
## Project Structure
 
```
src/main/java/pl/edu/vistula/firstrestapispring/
│
├── product/
│   ├── api/
│   │   ├── request/
│   │   │   ├── ProductRequest.java
│   │   │   └── UpdateProductRequest.java
│   │   ├── response/
│   │   │   └── ProductResponse.java
│   │   └── ProductController.java
│   ├── domain/
│   │   └── Product.java
│   ├── repository/
│   │   └── ProductRepository.java
│   ├── service/
│   │   └── ProductService.java
│   └── support/
│       ├── exception/
│       │   └── ProductNotFoundException.java
│       ├── ProductExceptionAdvisor.java
│       ├── ProductExceptionSupplier.java
│       └── ProductMapper.java
│
├── shared/
│   └── api/
│       └── response/
│           └── ErrorMessageResponse.java
│
└── FirstRestApiSpringApplication.java
```
 
---
### Use Cases & Testing Screenshots

0. Running Application in IntelliJ
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/5f27cbad-db51-4473-ac39-2a332dc8b512" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/eb6ca40c-0376-4c37-95e2-19611f43f5d0" />
 

 
1. Create a Product (POST) - Create Products and Items in the Database
 
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/7d73f63b-3e6c-41d2-88ed-4f8a07fac394" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/9a474514-5e2e-40f8-8543-3a565f7b5ee2" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/fb378b1d-667c-499a-92df-c5f6144d435c" />

2. Get Product by ID (GET)- Retrieves Products by their ID
 
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/f8a4d79d-5b9b-4f10-879e-06182fa6eb46" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/80be398f-9ea6-400d-9e6d-d38d9cbf556c" />

3. Get All Products (GET) - Retrieves all Products in the Database
 
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/05f41fec-ca43-4a69-8574-cedded716c4a" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/f988bc6f-23f5-42cf-94ad-87f1259ba8ff" />
 
 4. Update a Product (PUT)- Edits and Products Strings by their ID
 
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/8193d8f0-8de7-45a3-9e85-0c25197f0d4f" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/fddff7e0-3ab7-47ce-bf29-56ae08997b58" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/937e4dac-9f43-4c3f-bba5-282b7bf5afa7" />

 5. Delete a Product (DELETE)- Deletes products by their ID
 
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/03a5f084-d315-473d-8e81-d689c9860caf" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/1bd7a37e-7ca7-4fe3-b6fb-434076ccee5f" />

 6. Error Handling - Returns a Custom Error Message for unrelated ID's or Strings

<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/00fdfbcc-1cc0-4e28-985a-2b565662d4c9" />
<img width="300" height="250" alt="image" src="https://github.com/user-attachments/assets/3b8b4af5-a1fd-4034-a7f5-d6a06c27c7b5" />

Swagger UI
 
<img width="500" height="450" alt="image" src="https://github.com/user-attachments/assets/445b0a92-338e-494c-9f30-64699f77853a" />

H2 Database Console
 
<img width="500" height="450" alt="image" src="https://github.com/user-attachments/assets/4872029a-a7cf-44f2-8106-ba358eb1e5a2" />


 

 
