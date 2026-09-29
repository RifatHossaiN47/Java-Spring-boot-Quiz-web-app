# Java Spring Boot Quiz Web App

A full-stack Java quiz application built with Spring Boot, Spring Data JPA, MySQL, and Thymeleaf. It serves randomized Java trivia sessions, grades submissions server-side, and maintains a persistent leaderboard.

Deployed on Railway: [Live Demo](https://java-spring-boot-quiz-web-app-production.up.railway.app/)

---

## Highlights

- **Dynamic Question Sampling:** Selects a randomized set of 5 questions per session from a MySQL question pool.
- **Server-Side Grading:** Calculates score on form submission and persists participant records via Spring Data JPA.
- **Live Leaderboard:** Displays participant rankings ordered by score.
- **Cloud-Ready:** Configured with parameterized environment variables for zero-config Railway deployment using Nixpacks.

---

## Tech Stack

- **Backend:** Java 17, Spring Boot 2.4.4 (Spring Web, Spring Data JPA)
- **Persistence:** Hibernate, MySQL 8
- **Frontend:** Thymeleaf template engine, Bootstrap, CSS3
- **Build & Tooling:** Maven, Nixpacks
- **Deployment:** Railway

---

## Application Flow

1. **Home (`/`):** Validates and registers the participant's name.
2. **Quiz (`/questions`):** Renders 5 randomized multiple-choice questions bound to a session model.
3. **Submit (`/submit`):** Verifies submitted answers, calculates score, and writes the result to the database.
4. **Leaderboard (`/score`):** Queries and displays sorted results across all completed attempts.

---

## Local Setup

### Prerequisites
- Java 17 or higher
- MySQL 8.0+
- Git

### 1. Clone the repository
```bash
git clone https://github.com/RifatHossaiN47/Java-Spring-boot-Quiz-web-app.git
cd Java-Spring-boot-Quiz-web-app
```

### 2. Configure the database
Create a database named `quizapp` in your MySQL instance:
```sql
CREATE DATABASE quizapp;
```

Optionally export your database credentials as environment variables, or update `src/main/resources/application.properties`:
```bash
# Windows PowerShell
$env:DB_USERNAME="your_username"
$env:DB_PASSWORD="your_password"

# Linux / macOS
export DB_USERNAME="your_username"
export DB_PASSWORD="your_password"
```

### 3. Run the application
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

Once started, open `http://localhost:8080` in your browser. Seed questions are automatically loaded on startup via `data.sql`.

---

## Environment Variables

The application reads database and port settings from environment variables with sensible local defaults:

| Variable | Description | Default |
|---|---|---|
| `PORT` | Web server port | `8080` |
| `DATABASE_URL` | JDBC connection string | `jdbc:mysql://localhost:3306/quizapp` |
| `DB_USERNAME` | MySQL username | `root` |
| `DB_PASSWORD` | MySQL password | Local dev password |

---

## Project Structure

```
src/main/
├── java/com/devrezaur/main/
│   ├── SpringBootQuizStarterApplication.java
│   ├── maincontroller/
│   │   └── mainController.java       # Route handling and request mapping
│   ├── model/
│   │   ├── Question.java              # Question entity
│   │   ├── QuestionForm.java          # Form wrapper for batch quiz inputs
│   │   └── Result.java                # Score submission entity
│   ├── repository/
│   │   ├── QuestionRepo.java          # JPA repository for questions
│   │   └── ResultRepo.java            # JPA repository for leaderboard results
│   └── service/
│       └── QuizService.java           # Randomization and scoring business logic
└── resources/
    ├── application.properties         # App & datasource config
    ├── data.sql                       # Initial question dataset
    ├── static/css/                    # Custom stylesheets
    └── templates/                     # Thymeleaf HTML views
```

---

## Author

- **Rifat Hossain** — [@RifatHossaiN47](https://github.com/RifatHossaiN47)
- Starter template inspired by DevRezaur.
