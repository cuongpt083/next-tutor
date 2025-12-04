package com.cuongpt.nexttutor.controller;

import com.cuongpt.nexttutor.model.dto.request.GetHintRequestDTO;
import com.cuongpt.nexttutor.model.dto.request.InteractRequestDTO;
import com.cuongpt.nexttutor.model.dto.request.StartSessionRequestDTO;
import com.cuongpt.nexttutor.model.dto.response.GetHintResponseDTO;
import com.cuongpt.nexttutor.model.dto.response.InteractResponseDTO;
import com.cuongpt.nexttutor.model.dto.response.StartSessionResponseDTO;
import com.cuongpt.nexttutor.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * REST controller for learning session operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    /**
     * Starts a new learning session.
     * 
     * @param request the session start request
     * @return the session start response
     */
    @PostMapping("/start")
    public ResponseEntity<StartSessionResponseDTO> startSession(@RequestBody StartSessionRequestDTO request) {
        // For MVP, use a mock user ID. In production, extract from JWT token
        UUID mockUserId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        StartSessionResponseDTO response = sessionService.startSession(request, mockUserId);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles user interaction in a session.
     * 
     * @param sessionId the session ID
     * @param request   the interaction request
     * @return the interaction response
     */
    @PostMapping("/{sessionId}/interact")
    public ResponseEntity<InteractResponseDTO> interact(
            @PathVariable UUID sessionId,
            @RequestBody InteractRequestDTO request) {
        InteractResponseDTO response = sessionService.interact(sessionId, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Gets a hint for the current session.
     * 
     * @param sessionId the session ID
     * @param request   the hint request
     * @return the hint response
     */
    @PostMapping("/{sessionId}/hint")
    public ResponseEntity<GetHintResponseDTO> getHint(
            @PathVariable UUID sessionId,
            @RequestBody GetHintRequestDTO request) {
        GetHintResponseDTO response = sessionService.getHint(sessionId, request);
        return ResponseEntity.ok(response);
    }
}
