# Next Tutor - Backend Service

AI-powered English learning platform for children (5-16 years old).

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.2.0
- **Database**: PostgreSQL 15
- **Build Tool**: Maven

## Project Structure

```
src/
├── main/
│   ├── java/com/cuongpt/nexttutor/
│   │   ├── api/                    # API interfaces
│   │   ├── controller/             # REST controllers
│   │   ├── model/
│   │   │   ├── dto/
│   │   │   │   ├── request/        # Request DTOs
│   │   │   │   └── response/       # Response DTOs
│   │   │   └── entity/             # JPA entities
│   │   ├── repository/             # Data repositories
│   │   ├── service/                # Business logic services
│   │   ├── configuration/          # Spring configurations
│   │   ├── utility/                # Utility classes
│   │   └── common/                 # Common classes
│   └── resources/
│       ├── application.yaml        # Main configuration
│       ├── application-dev.yaml    # Development profile
│       └── liquibase/              # Database migrations
└── test/                           # Test classes

```

## Getting Started

### Prerequisites

- JDK 21
- Maven 3.8+
- PostgreSQL 15

### Database Setup

1. Create a PostgreSQL database:

```sql
CREATE DATABASE nexttutor_dev;
```

2. Update database credentials in `application-dev.yaml` if needed.

### Running the Application

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Documentation

### Authentication

- `POST /api/v1/auth/login` - OAuth2 login (Facebook/Zalo)

### Tutors

- `GET /api/v1/tutors` - Get available AI tutors

### Learning Sessions

- `POST /api/v1/sessions/start` - Start a new learning session
- `POST /api/v1/sessions/{sessionId}/interact` - Send user input to AI

### Quizzes

- `GET /api/v1/quizzes` - Get quiz questions
- `POST /api/v1/quizzes/{quizId}/submit` - Submit quiz answers

## Environment Variables

- `DB_URL`: Database connection URL
- `DB_USER`: Database username
- `DB_PASS`: Database password
- `JWT_SECRET`: Secret key for JWT token generation
- `OPENAI_API_KEYS`: OpenAI API keys (comma-separated)
- `GEMINI_API_KEYS`: Gemini API keys (comma-separated)
- `GROK_API_KEYS`: Grok API keys (comma-separated)

## Development

### Code Conventions

- Follow the coding conventions defined in `design/coding-conventions/1.api.convention.codeGeneration.md`
- Use comprehensive Javadoc for all public classes and methods
- Delegate detailed logic to private methods for better modularity

### Database Migrations

Database schema changes are managed using Liquibase. Add new changesets in:

```
src/main/resources/liquibase/changesets/
```

## License

Proprietary - Next Tutor Team
