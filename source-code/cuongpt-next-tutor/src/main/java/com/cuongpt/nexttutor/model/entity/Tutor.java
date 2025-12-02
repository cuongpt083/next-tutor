package com.cuongpt.nexttutor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing an AI tutor character in the Next Tutor system.
 * Tutors have distinct personalities and system prompts that define their
 * behavior.
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
     * Unique identifier for the tutor (e.g., "tutor_bear").
     */
    @Id
    @Column(length = 50)
    private String id;

    /**
     * Display name of the tutor (e.g., "Mr. Bear").
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Description of the tutor's personality and characteristics.
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * System prompt that defines the tutor's AI behavior and personality.
     */
    @Column(name = "system_prompt", nullable = false, columnDefinition = "TEXT")
    private String systemPrompt;

    /**
     * URL to the tutor's avatar image.
     */
    @Column(name = "avatar_url", columnDefinition = "TEXT")
    private String avatarUrl;
}
