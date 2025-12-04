package com.cuongpt.nexttutor.service;

import com.cuongpt.nexttutor.model.dto.AiMessageContentDTO;
import org.springframework.stereotype.Service;

/**
 * Mock AI service for MVP.
 * In production, this would integrate with OpenAI, Gemini, or Grok APIs.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Service
public class AiService {

    /**
     * Generates a mock AI response.
     * 
     * @param userInput the user's input
     * @param context   conversation context
     * @return AI response
     */
    public AiMessageContentDTO generateResponse(String userInput, String context) {
        // Mock response - in production, call actual AI API
        String response = "Thank you for saying: '" + userInput + "'. That's great! Can you tell me more?";

        return AiMessageContentDTO.builder()
                .text(response)
                .audioUrl(null) // TTS would be implemented here
                .build();
    }

    /**
     * Generates a hint for the user.
     * 
     * @param context current context
     * @return hint message
     */
    public String generateHint(String context) {
        return "Try describing what you see or feel. For example: 'I see...', 'I feel...', 'I think...'";
    }
}
