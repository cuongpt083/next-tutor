package com.cuongpt.nexttutor.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Next Tutor BFF (Backend For Frontend) service.
 * This BFF service acts as an intermediary between the Angular frontend and
 * backend services,
 * providing:
 * - User authentication via OAuth2 (Facebook, Zalo) with JWT token generation
 * - Learning session management and AI tutor interactions
 * - AI service integration with API key rotation
 * - Progress tracking and reporting
 * - Security layer to protect AI API keys from frontend exposure
 * 
 * Architecture Pattern: Backend For Frontend (BFF)
 * - Aggregates multiple backend services
 * - Transforms data for frontend consumption
 * - Handles cross-cutting concerns (auth, logging, error handling)
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@SpringBootApplication
public class NextTutorBffApplication {

    /**
     * Main entry point for the Spring Boot BFF application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NextTutorBffApplication.class, args);
    }
}
