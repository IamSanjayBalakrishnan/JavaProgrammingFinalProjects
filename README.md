# JavaProgrammingFinalProjects

# Task 1 — Spring Boot Web Application (Vistula University)


The Objective of Task 1:

- handles HTTP requests,
- returns plain text responses,
- returns HTML views using Thymeleaf,
- accepts parameters from the browser,
- displays dynamic content and images.
<img width="492" height="458" alt="image" src="https://github.com/user-attachments/assets/d62c9070-078e-47e2-b2f2-ca1fedbcd508" />
<img width="492" height="458" alt="image" src="https://github.com/user-attachments/assets/a169b679-44a3-4872-9ee3-ab3776ff3fa4" />


## 🚀 Technologies
- Spring Boot
- Spring Web
- Thymeleaf
- Maven


## 🌐 Endpoints

### 1. Plain text response
**URL:**  
`http://localhost:8080`

### 2. Thymeleaf greeting page
**URL:**  
`http://localhost:8080/greeting?name=Vistula`



# Task 2 Backend RestAPI Application with Swagger UI

-A Catalogue to store and retrieve Product Information with POST, GET, PUT, DELETE
-H2 In-Memory Database
-Abstracts database communication using Spring Data JPA.
- Handles incoming HTTP requests and structures outgoing JSON responses.
-Utilizing @RestControllerAdviceto build a centralized, cross-cutting error interception middleware that automatically catches failures

The project separates the application into distinct layers, where each component has an isolated responsibility


<img width="2009" height="1210" alt="image" src="https://github.com/user-attachments/assets/aed16328-eb94-4d8a-94b6-5ed7821489c5" />
<img width="1804" height="1187" alt="image" src="https://github.com/user-attachments/assets/0d0dbe82-6a06-4659-a673-759e0bc99186" />
<img width="1856" height="1293" alt="image" src="https://github.com/user-attachments/assets/5fdd7891-2e6a-4790-9530-d2e872caa0cf" />
<img width="712" height="933" alt="image" src="https://github.com/user-attachments/assets/be128629-6e29-4f95-b33a-d6b8b2b9dd27" />




Product: Core domain model, annotated with @Entity. It represents a literal table row inside your H2 relational database.

ProductNotFoundException:  runtime exception class. when user tries to look up or delete a product with an ID that isn't inside your database, the ProductServiceactively throws this specific exception to flag that an internal lookup search failed

ProductExceptionHandler: Annotated with @RestControllerAdvice. It silently listens across your entire application. If a ProductNotFoundExceptiongets thrown anywhere, this class interceptively grabs it, stops the app from crashing, strips away the ugly Java stack trace, and sends a beautifully clean 404 Not FoundJSON message back to the user instead.


ProductController: It exposes API URLs (like /api/v1/products). listens for incoming HTTP requests ( GET, POST, PUT, DELETE), takes the data out of the request, passes it to the ProductService for actual work, and returns the result back to the client along with an HTTP status code (like 200 OKor 201 Created).

ProductRequest: This is the filtered data structure sent back to the user. This class lets user to choose exactly what the client sees 

ProductService: This class holds your @Serviceannotation and contains the actual business rules. It bridges the controller and the database repository.

ProductRepository: It is an interface that extends Jpa Repository, Spring Data JPA reads its declaration and instantly auto-generates all the complex SQL statements under the hood. It provides with ready-to-use database tools

$$\text{Client (Browser/Postman)} \longrightarrow \text{ProductController} \longrightarrow \text{ProductService} \longrightarrow \text{ProductRepository} \longrightarrow \text{H2 Database}$$





PLEASE REFER TO TASK 1 AND TASK 2 FILES FOR THE SOURCE CODES


THANK YOU

NAME: SANJAY BALAKRISHNAN
STUDENT ID:73084












