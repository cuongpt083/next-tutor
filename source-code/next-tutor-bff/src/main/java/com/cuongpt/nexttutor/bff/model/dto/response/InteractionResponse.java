package com.cuongpt.nexttutor.bff.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response DTO for session interaction.
 * Contains the AI's response and optional feedback on user's input.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InteractionResponse {

    /**
     * AI tutor's response to the user's input.
     */
    private AIResponse aiResponse;

    /**
     * Optional feedback on the user's input (pronunciation, grammar, etc.).
     * May be null if no feedback is generated for this interaction.
     */
    private Feedback feedback;

    /**
     * Nested class containing the AI's response.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AIResponse {
        /**
         * Text content of the AI's response.
         */
        private String text;

        /**
         * URL to the audio file of the AI's response (TTS generated).
         */
        private String audioUrl;
    }

    /**
     * Nested class containing feedback on user's input.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feedback {
        /**
         * Score for the user's input (1-5 scale).
         */
        private Integer score;

        /**
         * Correction or suggestion text.
         */
        private String correction;

        /**
         * List of pronunciation errors detected.
         * Empty list if no errors or if input was text-only.
         */
        private List<String> pronunciationErrors;
    }
}
