# SpringBoot-Library-Service_BanqueMisr 📚

### Library Management (Dependency Injection + Profiles + CRUD)

## 👥 This project was developed exclusively by the following three contributors :
-  1: Ziad Sheref (Team Leader)
-  2: إسراء محمد السيد محمد
-  3:ندى محيى الدين حافظ عبدالعال

---

## 📌 Project Overview
This Spring Boot project demonstrates core concepts of Spring such as Dependency Injection, Profiles, Configuration Properties, Component Scanning, and full CRUD operations. The application simulates a simple library system.

---

## Project Requirements Breakdown

### ✅ Core Setup & Anatomy
- Initialized a Spring Boot project using [Spring Initializr](https://start.spring.io/) with **Web** and **Spring Data JPA** dependencies.
- Created the `@SpringBootApplication` main class inside a base package: `com.yourorg.library`.
- Exposed a `/health` endpoint that returns `"OK"` to confirm service is up.

### ✅ Dependency Injection Basics
- Created a `GreetingService` interface with two implementations:
  - `MorningGreetingService`
  - `EveningGreetingService`
- Injected the service into a controller in **three ways**:
  - Constructor Injection
  - Setter Injection
  - Field Injection

### ✅ Configuration & Profiles
- Created the following configuration files:
  - `application.properties`
  - `application-dev.yml`
  - `application-prod.yml`
- Externalized the following properties:
  - `library.name`
  - `library.mode`
- Created a `LibraryConfig` class with `@ConfigurationProperties` to bind these values.
- Demonstrated **profile activation** by setting `spring.profiles.active=dev` or `prod`.

### ✅ Component Scanning & Stereotypes
- Organized packages by feature:
  - `controller`
  - `service`
  - `repository`
  - `model`
  - `config`
- Used `@ComponentScan` with include/exclude filters to selectively load beans.
- Wrote a simple test to assert that excluded beans are not loaded into the application context.

### ✅ Advanced Dependency Injection
- Created two implementations of `NotificationService`:
  - `EmailNotificationService` (annotated with `@Primary`)
  - `SmsNotificationService` (annotated with `@Qualifier("sms")`)
- Injected both into `NotificationController`, with endpoints:
  - `/notify/email`
  - `/notify/sms`

### ✅ CRUD Operations
- Created a `Book` entity with fields like `id`, `title`, `author`.
- Created a `BookRepository` Implemented an in-memory list to store books.
- Created a `BookService` that simply delegates calls to the repository.
- Built a `BookController` that supports full CRUD via REST endpoints:
  - `GET /api/books`
  - `GET /api/books/{id}`
  - `POST /api/books`
  - `PUT /api/books/{id}`
  - `DELETE /api/books/{id}`

---

## Project Structure
```
com.sprints.library
├── config
├── controller
├── service
├── repository
├── model
└── LibraryApplication.java
```

---

## Configuration Files
- `application.properties` (contains common configuration)
- `application-dev.yml` and `application-prod.yml` (contains environment-specific properties)

---

## Run Instructions
1. Clone the repository
2. Set profile: `spring.profiles.active=dev` in `application.properties`
3. Run the application using your IDE or `./mvnw spring-boot:run`
4. Access endpoints like `/health`, `/api/books`, `/notify/email`

---

## 📝 Notes
- Make sure your profile-specific YAML files are properly indented.
- Ensure dependencies are up to date in your `pom.xml`
- Customize `library.name` and `library.mode` per environment
For any issues or contributions, feel free to open a pull request or contact the team members.

