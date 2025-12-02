package com.cuongpt.nexttutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Next Tutor - AI-powered English learning platform.
 * This application serves as the Backend For Frontend (BFF) service that handles:
 * - User authentication via OAuth2 (Facebook, Zalo)
 * - Learning session management (Speaking, Listening, Reading, Writing)
 * - AI integration for tutoring and feedback
 * - Progress tracking and reporting
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@SpringBootApplication
public class NextTutorApplication {

    /**
     * Main entry point for the Spring Boot application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NextTutorApplication.class, args);
    }
}
