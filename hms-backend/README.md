# 🏥 Secure Hospital Management System (Backend)

A robust, enterprise-grade backend for managing hospital patient records. This system is built with **Spring Boot** and focuses on **Data Security** using Role-Based Access Control (RBAC) and encryption standards.

## 🚀 Key Features

* **Secure Authentication:** Implementation of **Spring Security** with Basic Auth.
* **Role-Based Access Control (RBAC):**
    * `ADMIN`: Full access to Create, Read, Update, and Delete (CRUD).
    * `USER`: Restricted access (View only).
* **Password Encryption:** Utilizes **BCrypt** hashing to ensure zero-knowledge password storage.
* **Database Management:** Automated schema creation using **Hibernate/JPA** and **MySQL**.
* **RESTful API:** Fully documented endpoints for frontend integration.

## 🛠️ Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot 3.4
* **Security:** Spring Security & BCrypt
* **Database:** MySQL 8.0
* **Testing:** Thunder Client / Postman

## ⚙️ How to Run

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/hms-backend-java.git](https://github.com/YOUR_USERNAME/hms-backend-java.git)
    ```
2.  **Configure Database**
    * Create a MySQL database named `hospital_db`.
    * Update `src/main/resources/application.properties` with your MySQL credentials.
3.  **Run the Application**
    * Open the project in VS Code or IntelliJ.
    * Run `HmsBackendApplication.java`.
4.  **Default Admin Credentials**
    * **Username:** `admin`
    * **Password:** `admin123` (Automatically hashed on startup)

## 🔌 API Endpoints

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/patients` | List all patients | ✅ Yes |
| `POST` | `/api/patients` | Add a new patient | ✅ Yes (Admin) |
| `PUT` | `/api/patients/{id}` | Update patient details | ✅ Yes (Admin) |
| `DELETE` | `/api/patients/{id}` | Remove a patient | ✅ Yes (Admin) |

## 🛡️ Security Highlight
This project moves beyond standard CRUD by implementing a **CustomUserDetailsService**. It bridges the gap between the application's SQL database and Spring Security's authentication context, allowing for dynamic user management without hardcoding credentials.

---
*Built by Kutlwanelo Moagi as part of my projects.*