# Notes API
a simple Spring Boot REST API for managing tasks, using an in-memory H2 database.

This project demonstrates the standard Spring Boot structure with Controllers, Services, Repositories, and Entities.

## Getting Started
### Prerequisites

- Java 17+  
- Maven or Gradle  
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application

1. Clone the repository:

```bash
git clone <repository_url>
cd first-spring-app
```
2. Run directly from the IDE by running "src/main/java/com/example/first_spring_app/FirstSpringApp.java"

## H2 In-Memory Database
to see the in-memory db, go to 
http://localhost:8080/h2-console
with the following fields
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: leave blank

Important things to note:
- Tables are auto-created from the Task entity on startup.
- Data is lost when the application stops.
- Hibernate logs SQL queries in the console (spring.jpa.show-sql=true).

## Endpoints
| Method | Endpoint      | Description                    |
| ------ | ------------- | ------------------------------ |
| GET    | `/task`      | Get all tasks                  |
| GET    | `/task/{id}` | Get a single task by ID        |
| POST   | `/task`      | Create a new task              |
| PUT  | `/task/{id}`      | update a task by ID, ensure all fields (description, status) are included in the request. Valid values for status are "todo", "in-progress", and "completed"              |
| DELETE | `/task/{id}` | Delete a task by ID            |

## Example Request (PUT /task/{id}
```
{
    "description": "do stuff",
    "status": "in-progress"
}
```
## Technologies
Java 17+
Spring Boot 3.x
Spring Web (REST API)
Spring Data JPA
H2 Database (in-memory)
Maven
