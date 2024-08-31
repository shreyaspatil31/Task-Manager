# Task Manager Application

This is a Task Manager application built using Spring Boot, Hibernate, REST API, and MySQL. The application allows users to manage tasks and their associated notes, providing features to create, read, update, and delete tasks and notes.

## Features

- **Task Management:**
  - Create new tasks with title, description, and deadline.
  - Update existing tasks.
  - Delete tasks.
  - Mark tasks as completed.

- **Note Management:**
  - Add notes to tasks.
  - Retrieve all notes associated with a task.

## Technologies Used

- **Backend:**
  - Spring Boot
  - Hibernate
  - REST API
  - MySQL

## Project Structure

```plaintext
TaskManager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/TaskManager/
│   │   │       ├── controllers/
│   │   │       │   └── TaskController.java
│   │   │       ├── dto/
│   │   │       │   ├── CreateNoteDTO.java
│   │   │       │   ├── CreateTaskDTO.java
│   │   │       │   └── UpdateTaskDTO.java
│   │   │       ├── entities/
│   │   │       │   ├── NoteEntity.java
│   │   │       │   └── TaskEntity.java
│   │   │       ├── repositories/
│   │   │       │   ├── NoteRepository.java
│   │   │       │   └── TaskRepository.java
│   │   │       ├── service/
│   │   │       │   └── TaskService.java
│   │   │       └── TaskManagerApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8.0+
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/task-manager.git
   cd task-manager
   ```

2. **Set up the MySQL database:**

   - Create a new database named `taskmanagerdb`.
   - Update the `application.properties` file with your MySQL credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/taskmanagerdb
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Build and run the application:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the application:**

   The application will be accessible at `http://localhost:8086`.

## REST API Endpoints

### Task Endpoints

- **GET /tasks** - Retrieve all tasks.
- **GET /tasks/{id}** - Retrieve a specific task by ID.
- **POST /tasks** - Create a new task.
- **PATCH /tasks/{id}** - Update an existing task.
- **DELETE /tasks/{id}** - Delete a task.

### Note Endpoints

- **POST /tasks/{id}/notes** - Add a note to a task.
- **GET /tasks/{id}/notes** - Retrieve all notes for a task.

## Configuration

- **Application Port:** `8086`
- **Database Configuration:** Located in `src/main/resources/application.properties`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## Contact

- **Author:** Shreyas Patil
- **Email:** [shreyaspatil554@gmail.com](shreyaspatil554@gmail.com)

---
