# Task Management System

This is a simple **Task Management System** built with **Spring Boot**, **H2 Database** (in-memory), and **Basic Authentication**. Users can create, update, view, and delete tasks, all while being protected by authentication.

## Features:
- Task CRUD (Create, Read, Update, Delete) functionality.
- Basic Authentication for accessing the API.
- H2 Database (in-memory) for storing tasks.
- Exception handling for missing resources.
- User authentication.

---

### **Prerequisites**

1. **Java 21** (for running the Spring Boot application).
2. **Maven** (for building the project).
3. **Postman** (for API testing, optional).

---

### **Running the Application**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/task-management-system.git
   cd task-management-system

2. **Run the application**:
   ```bash
   mvn spring-boot:run

3. **Access the application**:
   The application will be accessible at http://localhost:8080.By default,it uses Basic Authentication.

4. **Test the API**:
   Use Postman or any HTTP client to test the application.

### **Testing the Application**
1. Add the following authorization to each request:
   Type: Basic Auth
   Username: user
   Password: user@123

2. Use the above endpoints to create, retrieve, update, and delete tasks.