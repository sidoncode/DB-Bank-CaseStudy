# 🏦 Trade Reconciliation System

A Spring Boot-based microservice for managing and reconciling trades in a financial institution. It includes RESTful APIs, PostgreSQL, Redis caching, Swagger documentation, structured logging, and profile-based environment configuration.

---

## 📌 Features

- Real-time trade monitoring
- Redis caching to reduce DB hits
- CRUD APIs for Trades and Instruments
- Environment-based configuration (UAT, QA, PROD)
- Structured logging and centralized error handling
- Swagger/OpenAPI for API testing
- PostgreSQL with schema/data bootstrapping

---

## ⚙️ Tech Stack

| Layer          | Technology                  |
|----------------|-----------------------------|
| Backend        | Spring Boot (REST API)      |
| Database       | PostgreSQL                  |
| Caching        | Redis                       |
| ORM            | Spring Data JPA             |
| Documentation  | Swagger (springdoc-openapi) |
| Build Tool     | Maven                       |

---

## 📁 High-Level Design


src/
├── main/
│ ├── java/com/DBBank/trade/reconciliation/
│ │ ├── controller/ # REST endpoints
│ │ ├── service/ # Business logic layer
│ │ ├── model/ # Entities (Trade, Instrument)
│ │ ├── repository/ # JPA Repositories
│ │ ├── config/ # Swagger, Redis, Exception config
│ │ └── TradeReconciliationApplication.java
│ └── resources/
│ ├── application.yml # Profiles (dev, qa, prod)
│ ├── schema.sql # DDL for PostgreSQL
│ └── data.sql # Sample data

