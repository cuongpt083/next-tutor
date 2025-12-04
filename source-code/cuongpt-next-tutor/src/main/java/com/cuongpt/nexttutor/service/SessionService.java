package com.cuongpt.nexttutor.service;

import com.cuongpt.nexttutor.model.dto.AiMessageContentDTO;
import com.cuongpt.nexttutor.model.dto.FeedbackDTO;
import com.cuongpt.nexttutor.model.dto.request.GetHintRequestDTO;
import com.cuongpt.nexttutor.model.dto.request.InteractRequestDTO;
import com.cuongpt.nexttutor.model.dto.request.StartSessionRequestDTO;
import com.cuongpt.nexttutor.model.dto.response.GetHintResponseDTO;
import com.cuongpt.nexttutor.model.dto.response.InteractResponseDTO;
import com.cuongpt.nexttutor.model.dto.response.StartSessionResponseDTO;
import com.cuongpt.nexttutor.model.entity.LearningSession;
import com.cuongpt.nexttutor.model.entity.Tutor;
import com.cuongpt.nexttutor.model.entity.User;
import com.cuongpt.nexttutor.model.enums.SessionMode;
import com.cuongpt.nexttutor.repository.LearningSessionRepository;
import com.cuongpt.nexttutor.repository.TutorRepository;
import com.cuongpt.nexttutor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Service for managing learning sessions.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class SessionService {

    private final LearningSessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;
    private final AiService aiService;

    /**
     * Starts a new learning session.
     * 
     * @param request the session start request
     * @param userId  the user ID (from authentication)
     * @return the session start response
     */
    @Transactional
    public StartSessionResponseDTO startSession(StartSessionRequestDTO request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tutor tutor = tutorRepository.findById(request.getTutorId())
                .orElseThrow(() -> new RuntimeException("Tutor not found"));

        LearningSession session = LearningSession.builder()
                .user(user)
                .tutor(tutor)
                .topicId(request.getTopicId())
                .mode(request.getMode().getValue())
                .status("ACTIVE")
                .build();

        session = sessionRepository.save(session);

        // Generate initial message
        String initialText = String.format(
                "Hello! I'm %s. Let's practice %s today. Are you ready?",
                tutor.getName(),
                request.getTopicId());

        AiMessageContentDTO initialMessage = AiMessageContentDTO.builder()
                .text(initialText)
                .audioUrl(null)
                .build();

        return StartSessionResponseDTO.builder()
                .sessionId(session.getId())
                .initialMessage(initialMessage)
                .build();
    }

    /**
     * Handles user interaction in a session.
     * 
     * @param sessionId the session ID
     * @param request   the interaction request
     * @return the interaction response
     */
    @Transactional
    public InteractResponseDTO interact(UUID sessionId, InteractRequestDTO request) {
        LearningSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        // Generate AI response
        AiMessageContentDTO aiResponse = aiService.generateResponse(
                request.getContent(),
                session.getTopicId());

        // Mock feedback
        FeedbackDTO feedback = FeedbackDTO.builder()
                .score(4)
                .correction("Good job! Keep practicing.")
                .build();

        return InteractResponseDTO.builder()
                .aiResponse(aiResponse)
                .feedback(feedback)
                .build();
    }

    /**
     * Provides a hint for the current session.
     * 
     * @param sessionId the session ID
     * @param request   the hint request
     * @return the hint response
     */
    public GetHintResponseDTO getHint(UUID sessionId, GetHintRequestDTO request) {
        LearningSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        String hintText = aiService.generateHint(session.getTopicId());

        return GetHintResponseDTO.builder()
                .hintText(hintText)
                .hintAudioUrl(null)
                .build();
    }
}
