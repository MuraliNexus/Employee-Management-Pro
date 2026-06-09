# 🚀 Employee Management Pro

A comprehensive Spring Boot REST API project demonstrating real-world Employee Management with advanced JPA/Hibernate concepts including entity relationships, dynamic filtering, pagination, sorting, and CRUD operations.

---

## 📌 Project Overview

This project manages Employees, Departments, Addresses, and Projects while showcasing:

* RESTful API Development
* Spring Boot Architecture
* Spring Data JPA
* Hibernate ORM
* Entity Relationships
* Dynamic Query Filtering using Specifications
* Pagination and Sorting
* MySQL Database Integration

---
## Entity Relationship Diagram

![Entity Relationship Diagram](relationship.JPG)

---

## 🛠️ Tech Stack

| Technology      | Usage                 |
| --------------- | --------------------- |
| Java            | Programming Language  |
| Spring Boot     | Backend Framework     |
| Spring Data JPA | Database Access       |
| Hibernate       | ORM Framework         |
| MySQL           | Database              |
| Maven           | Dependency Management |
| Git             | Version Control       |
| GitHub          | Repository Hosting    |

---

# 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── com.murali.employeemanagement
    │       ├── Controller
    │       │   └── AppController.java
    │       │
    │       ├── AppService
    │       │   └── AppService.java
    │       │
    │       ├── Entity
    │       │   ├── Employee.java
    │       │   ├── Department.java
    │       │   ├── Address.java
    │       │   └── Project.java
    │       │
    │       ├── Repoistory
    │       │   ├── EmployeeRepoistory.java
    │       │   ├── DepartmentRepoistory.java
    │       │   ├── AddressRepoistory.java
    │       │   └── ProjectRepoistory.java
    │       │
    │       └── Specifications
    │           └── EmployeeSpecification.java
    │
    └── resources
        └── application.properties
```

---

# 🗄️ Entity Relationships

## Employee ↔ Department

### Many-To-One

Many Employees belong to one Department.

```java
@ManyToOne
@JoinColumn(name = "dept_id")
private Department department;
```

---

## Employee ↔ Address

### One-To-One

One Employee has one Address.

```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "address_id")
private Address address;
```

---

## Employee ↔ Project

### Many-To-Many

One Employee can work on multiple Projects and one Project can have multiple Employees.

```java
@ManyToMany
@JoinTable(...)
private List<Project> projects;
```

---

# 🔥 Features

## Employee Management

✅ Create Employee

✅ Update Employee

✅ Delete Employee

✅ View Employees

---

## Department Management

✅ Create Department

✅ Update Department

✅ Delete Department

✅ View Departments

---

## Project Management

✅ Create Project

✅ Update Project

✅ Delete Project

---

## Address Management

✅ One-To-One Employee Address Mapping

---

# 📖 Pagination

Supports page-based data retrieval.

Example:

```http
GET /App/filter?pageNo=1&pageSize=5
```

Benefits:

* Faster API responses
* Reduced memory usage
* Better user experience

---

# ↕️ Sorting

Supports dynamic sorting.

Example:

```http
GET /App/filter?sortBy=name&sortDir=ASC
```

or

```http
GET /App/filter?sortBy=id&sortDir=DESC
```

---

# 🔍 Dynamic Filtering

Implemented using:

```java
Specification<Employee>
```

Supported Filters:

* Employee ID
* Employee Name
* Department Name
* City
* State
* Project Name

Example:

```http
GET /App/filter?name=Murali
```

```http
GET /App/filter?city=Chennai
```

```http
GET /App/filter?projectName=SpringBoot
```

Multiple filters can be combined.

Example:

```http
GET /App/filter?name=Murali&city=Chennai
```

---

# 🎯 Spring Data JPA Specifications

Dynamic queries are generated using:

```java
CriteriaBuilder
CriteriaQuery
Predicate
Specification
```

Benefits:

* Flexible filtering
* Cleaner repository layer
* Scalable query construction

---

# 🌐 REST API Endpoints

## Employee APIs

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /App/employee      |
| GET    | /App/employees     |
| PUT    | /App/employee/{id} |
| DELETE | /App/employee/{id} |

---

## Department APIs

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | /App/department      |
| GET    | /App/departments     |
| PUT    | /App/department/{id} |
| DELETE | /App/department/{id} |

---

## Project APIs

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /App/projects      |
| PUT    | /App/projects/{id} |
| DELETE | /App/projects/{id} |

---

## Filtering API

| Method | Endpoint    |
| ------ | ----------- |
| GET    | /App/filter |

---

# 💾 Database

Database Used:

```text
MySQL
```

Hibernate Configuration:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

# 📸 API Screenshots

## Create Department API

![Create Department API](postman_department_upload.JPG)

## Create Employee API

![Create Employee API](postman_employee_upload.JPG)

## Dynamic Filtering, Pagination & Sorting

![Filter Pagination Sorting](filter_sorting_pagination.JPG)

---
# 🔄 Application Flow

### 1. Create Departments

The HR administrator creates departments such as:

* Human Resources
* Information Technology
* Finance
* Marketing
* Operations

Each department is assigned a unique Department ID.

⬇️

### 2. Create Projects

The administrator creates projects such as:

* Employee Portal
* Payroll System
* Attendance Management
* Recruitment Tracking
* Performance Dashboard

Each project is assigned a unique Project ID.

⬇️

### 3. Create Employees

While creating an employee, the administrator selects:

* Employee Name
* Department ID
* One or More Project IDs
* City
* State

Example:

Department ID → 2 (Information Technology)

Project IDs → 1, 3, 5

The application automatically establishes:

* Many-to-One → Employee → Department
* One-to-One → Employee → Address
* Many-to-Many → Employee ↔ Projects

⬇️

### 4. Store Data in MySQL

All employee, department, project, address, and relationship data are stored in MySQL using Spring Data JPA and Hibernate.

⬇️

### 5. Retrieve Employees

Users can retrieve employee information using:

* Dynamic Filtering
* Pagination
* Sorting

Examples:

* Filter by Department
* Filter by Project
* Filter by City
* Sort by Employee ID
* Paginate Results

⬇️

### 6. Display Results

The application returns structured JSON responses containing:

* Employee Details
* Department Information
* Assigned Projects
* Address Information

This enables efficient employee management and data retrieval in an HR environment.


---

# 🚀 How To Run

## Clone Repository

```bash
git clone https://github.com/MuraliNexus/Employee-Management-Pro.git
```

## Configure Database

Update:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

## Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```


---

# 📚 Concepts Demonstrated

* Spring Boot REST APIs
* JPA/Hibernate
* One-To-One Mapping
* One-To-Many Mapping
* Many-To-One Mapping
* Many-To-Many Mapping
* Join Tables
* Pagination
* Sorting
* Dynamic Filtering
* Specifications API
* MySQL Integration
* Maven Project Structure
* Repository Pattern

---

# 👨‍💻 Author

Murali

Backend Developer | Java | Spring Boot | MySQL

GitHub:
https://github.com/MuraliNexus
