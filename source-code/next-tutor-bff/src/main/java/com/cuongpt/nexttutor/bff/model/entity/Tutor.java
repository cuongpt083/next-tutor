package com.cuongpt.nexttutor.bff.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing an AI tutor character in the Next Tutor system.
 * Tutors have distinct personalities defined by their system prompts,
 * which guide the AI's behavior during learning sessions.
 * 
 * Database Table: tutors
 * Primary Key: id (String)
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Entity
@Table(name = "tutors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    /**
     * Unique identifier for the tutor (e.g., "tutor_bear", "tutor_rabbit").
     * Used as a stable reference across the system.
     */
    @Id
    @Column(length = 50)
    private String id;

    /**
     * Display name of the tutor (e.g., "Mr. Bear", "Miss Rabbit").
     * Shown to users in the tutor selection interface.
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Description of the tutor's personality and characteristics.
     * Helps users understand the tutor's teaching style.
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * System prompt that defines the tutor's AI behavior and personality.
     * This prompt is sent to the LLM to establish the tutor's character,
     * teaching style, and interaction patterns.
     */
    @Column(name = "system_prompt", nullable = false, columnDefinition = "TEXT")
    private String systemPrompt;

    /**
     * URL to the tutor's avatar image.
     * Used for visual representation in the UI.
     */
    @Column(name = "avatar_url", columnDefinition = "TEXT")
    private String avatarUrl;
}
