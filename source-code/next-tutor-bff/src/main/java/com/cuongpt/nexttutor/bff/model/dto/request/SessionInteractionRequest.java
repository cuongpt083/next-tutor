package com.cuongpt.nexttutor.bff.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for session interaction.
 * Contains user input (text or audio) to send to the AI tutor.
 * 
 * Validation:
 * - inputType: Required, must be TEXT or AUDIO
 * - content: Required, contains the user's message or transcribed text
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionInteractionRequest {

    /**
     * Type of input being sent.
     * Valid values: TEXT, AUDIO
     * For AUDIO, the content should be the transcribed text from STT.
     */
    @NotBlank(message = "Input type is required")
    private String inputType;

    /**
     * Content of the user's input.
     * For TEXT: the actual message text
     * For AUDIO: the transcribed text from speech-to-text processing
     */
    @NotBlank(message = "Content is required")
    private String content;
}
