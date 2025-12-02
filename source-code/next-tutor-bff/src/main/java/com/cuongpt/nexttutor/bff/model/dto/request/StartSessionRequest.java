package com.cuongpt.nexttutor.bff.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for starting a new learning session.
 * Contains parameters to initialize a session with specific tutor, mode, topic,
 * and level.
 * 
 * Validation:
 * - tutorId: Required
 * - mode: Required, must be SPEAKING, ROLE_PLAY, or QUIZ
 * - topicId: Required
 * - level: Required
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartSessionRequest {

    /**
     * ID of the AI tutor to conduct the session.
     * Must reference an existing tutor (e.g., "tutor_bear").
     */
    @NotBlank(message = "Tutor ID is required")
    private String tutorId;

    /**
     * Mode of the learning session.
     * Valid values: SPEAKING, ROLE_PLAY, QUIZ
     */
    @NotBlank(message = "Mode is required")
    private String mode;

    /**
     * ID of the topic to cover in the session.
     * Must reference an existing topic (e.g., "topic_travel").
     */
    @NotBlank(message = "Topic ID is required")
    private String topicId;

    /**
     * Proficiency level of the learner.
     * Valid values: A1, A2, B1, B2, Starters, Movers, Flyers
     */
    @NotBlank(message = "Level is required")
    private String level;
}
