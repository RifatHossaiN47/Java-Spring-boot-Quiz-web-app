# 🎯 Java Spring Boot Quiz Web Application

A full-stack quiz application built with Spring Boot, MySQL, and Thymeleaf that allows users to take randomized Java programming quizzes and compete on a global scoreboard.

## 🌐 Live Demo

**Deployed Application:** [https://java-spring-boot-quiz-web-app-production.up.railway.app/](https://java-spring-boot-quiz-web-app-production.up.railway.app/)

---

## 📋 Features

- **Dynamic Quiz Generation**: Randomly selects 5 questions from a pool of 10 Java programming questions
- **Multiple Choice Questions**: Three options per question with instant result calculation
- **User Score Tracking**: Saves user results to MySQL database
- **Global Scoreboard**: View rankings sorted by highest scores
- **Responsive Design**: Clean UI built with Thymeleaf templates and custom CSS
- **Input Validation**: Ensures users enter their name before starting the quiz
- **Duplicate Prevention**: Prevents multiple submissions of the same quiz

---

## 🛠️ Technology Stack

### Backend
- **Spring Boot 2.4.4** - Application framework
- **Spring Data JPA** - Database ORM
- **Hibernate** - JPA implementation
- **MySQL** - Relational database
- **Java 17** - Programming language

### Frontend
- **Thymeleaf** - Server-side template engine
- **HTML5/CSS3** - Markup and styling
- **Bootstrap** - Responsive design components

### DevOps & Deployment
- **Railway** - Cloud hosting platform
- **Maven** - Build automation tool
- **Git/GitHub** - Version control

---

## 📁 Project Structure

```
spring-boot-quiz-starter/
├── src/
│   ├── main/
│   │   ├── java/com/devrezaur/main/
│   │   │   ├── SpringBootQuizStarterApplication.java   # Main application entry point
│   │   │   ├── maincontroller/
│   │   │   │   └── mainController.java                 # Handles all HTTP requests
│   │   │   ├── model/
│   │   │   │   ├── Question.java                       # Question entity
│   │   │   │   ├── QuestionForm.java                   # Form wrapper for questions
│   │   │   │   └── Result.java                         # Result entity
│   │   │   ├── repository/
│   │   │   │   ├── QuestionRepo.java                   # Question repository
│   │   │   │   └── ResultRepo.java                     # Result repository
│   │   │   └── service/
│   │   │       └── QuizService.java                    # Business logic layer
│   │   └── resources/
│   │       ├── application.properties                   # Configuration file
│   │       ├── data.sql                                 # Initial database data
│   │       ├── static/
│   │       │   ├── css/                                 # Stylesheets
│   │       │   └── images/                              # Image assets
│   │       └── templates/                               # Thymeleaf HTML templates
│   │           ├── index.html                           # Home page
│   │           ├── quiz.html                            # Quiz page
│   │           ├── result.html                          # Result page
│   │           ├── scoreboard.html                      # Scoreboard page
│   │           ├── navbar.html                          # Navigation component
│   │           └── footer.html                          # Footer component
├── pom.xml                                              # Maven dependencies
├── system.properties                                    # Java runtime version
└── nixpacks.toml                                        # Railway build configuration
```

---

## 🎮 How It Works

1. **Home Page** (`/`)
   - User enters their name to start the quiz
   - Input validation ensures name is not empty

2. **Quiz Page** (`/questions`)
   - Displays 5 randomly selected questions
   - Each question has 3 multiple-choice options
   - User selects answers and submits the quiz

3. **Result Page** (`/submit`)
   - Shows the user's score (X out of 5 correct)
   - Saves the result to the database
   - Prevents duplicate submissions

4. **Scoreboard** (`/score`)
   - Displays all quiz results sorted by highest score
   - Shows username and total correct answers

---

## 🔧 Key Components

### Models
- **Question**: Represents a quiz question with options and correct answer
- **QuestionForm**: Wrapper containing 5 questions for a quiz session
- **Result**: Stores user quiz results (username and score)

### Controller
- **mainController**: Handles all HTTP requests
  - `GET /` - Home page
  - `POST /questions` - Start quiz
  - `POST /submit` - Submit answers
  - `GET /score` - View scoreboard

### Service Layer
- **QuizService**: Business logic
  - Random question selection
  - Score calculation
  - Result persistence
  - Scoreboard retrieval

---

## 💾 Database Schema

### Questions Table
```sql
questions (
  ques_id INT PRIMARY KEY,
  title VARCHAR(255),
  optionA VARCHAR(255),
  optionB VARCHAR(255),
  optionC VARCHAR(255),
  ans INT,
  chose INT
)
```

### Results Table
```sql
results (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  total_correct INT
)
```

---

## 🚀 Deployment Guide (Railway)

### Prerequisites
- GitHub account
- Railway account
- Git installed locally

### Steps

1. **Prepare Configuration Files**
   - `application.properties` - Configure environment variables
   - `system.properties` - Set Java version to 17
   - `nixpacks.toml` - Define build and start commands

2. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Deploy to Railway"
   git push origin main
   ```

3. **Deploy on Railway**
   - Create new project from GitHub repository
   - Add MySQL database service
   - Set environment variables:
     - `DATABASE_URL`: JDBC connection string with parameters
     - `DB_USERNAME`: Database username
     - `DB_PASSWORD`: Database password
   - Generate domain for public access

---

## 🏃‍♂️ Running Locally

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/RifatHossaiN47/Java-Spring-boot-Quiz-web-app.git
   cd spring-boot-quiz-starter
   ```

2. **Configure MySQL Database**
   - Create database: `CREATE DATABASE quizapp;`
   - Update `application.properties` with your MySQL credentials

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**
   - Open browser: `http://localhost:8080`

---

## 📦 Dependencies

```xml
<!-- Spring Boot Starters -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Database -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<!-- Development Tools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

---

## 🎨 Sample Questions

The quiz includes 10 Java programming questions covering:
- Basic syntax and output methods
- Comments and documentation
- Data types (String, int, float)
- Operators and comparisons
- String methods
- Variable declarations

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest new features
- Submit pull requests

---

## 📝 License

This project is open-source and available for educational purposes.

---

## 👨‍💻 Author

**RifatHossaiN47**
- GitHub: [@RifatHossaiN47](https://github.com/RifatHossaiN47)

---

## 🙏 Acknowledgments

- Original starter code concept from DevRezaur
- Spring Boot documentation and community
- Railway platform for seamless deployment

---

**Live Application:** [https://java-spring-boot-quiz-web-app-production.up.railway.app/](https://java-spring-boot-quiz-web-app-production.up.railway.app/)

**Repository:** [https://github.com/RifatHossaiN47/Java-Spring-boot-Quiz-web-app](https://github.com/RifatHossaiN47/Java-Spring-boot-Quiz-web-app)

---

### 🎯 Enjoy the Quiz! Good Luck! 🚀
