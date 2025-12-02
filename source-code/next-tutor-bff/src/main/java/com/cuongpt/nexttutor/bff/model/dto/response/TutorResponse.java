package com.cuongpt.nexttutor.bff.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for tutor information.
 * Contains tutor details for frontend display.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorResponse {

    /**
     * Unique identifier for the tutor.
     */
    private String id;

    /**
     * Display name of the tutor.
     */
    private String name;

    /**
     * Description of the tutor's personality and teaching style.
     */
    private String description;

    /**
     * URL to the tutor's avatar image.
     */
    private String avatarUrl;

    /**
     * System prompt defining the tutor's AI behavior.
     * Note: This is exposed to frontend for transparency,
     * but actual AI calls are made from backend only.
     */
    private String personalityPrompt;
}
