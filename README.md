# HealthPlus - A Microservices-Based Healthcare Management System

This project is a **Microservices-based Healthcare Management System** built using Spring Boot and Spring Cloud. It provides services like patient management, doctor management, billing, and more through independent microservices.

---

## 🔧 Tech Stack

- **Java**, **Spring Boot**, **Spring Cloud**, **Spring Security**
- **Spring Data JPA**, **Hibernate**
- **Eureka Server**, **API Gateway**
- **MySQL**, **PostgreSQL**
- **Elasticsearch** (for search functionality)
- **JWT** for authentication
- **Angular** / **React** (Optional for frontend)
- **Maven**, **STS/IntelliJ**, **Postman**

---

## 🧩 Microservices in This Project

| Microservice       | Description                                 |
|--------------------|---------------------------------------------|
| `patientmicroservice` | Handles patient registration and data        |
| `doctormicroservice`  | Manages doctor profiles and appointments    |
| `billingmicroservice` | Generates bills and payment details         |
| `gateway-api`         | API Gateway for routing and load balancing  |
| `eureka-server`       | Service Discovery using Spring Eureka       |

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/ErNitesh-d/HealthPlus-A-Microservices-Based-Healthcare-Management-System.git
   cd HealthPlus-A-Microservices-Based-Healthcare-Management-System
