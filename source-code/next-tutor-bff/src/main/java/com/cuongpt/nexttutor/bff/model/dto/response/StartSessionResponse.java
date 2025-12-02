package com.cuongpt.nexttutor.bff.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for starting a learning session.
 * Contains the session ID and initial message from the AI tutor.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartSessionResponse {

    /**
     * Unique identifier for the newly created session.
     * Used for subsequent interaction requests.
     */
    private String sessionId;

    /**
     * Initial message from the AI tutor to start the conversation.
     */
    private InitialMessage initialMessage;

    /**
     * Nested class containing the initial AI message.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InitialMessage {
        /**
         * Text content of the initial message.
         */
        private String text;

        /**
         * URL to the audio file of the initial message (TTS generated).
         */
        private String audioUrl;
    }
}
