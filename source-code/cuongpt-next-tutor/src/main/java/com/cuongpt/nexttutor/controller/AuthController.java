package com.cuongpt.nexttutor.controller;

import com.cuongpt.nexttutor.model.dto.request.LoginRequestDTO;
import com.cuongpt.nexttutor.model.dto.response.LoginResponseDTO;
import com.cuongpt.nexttutor.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for authentication operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Handles user login via OAuth provider.
     * 
     * @param request the login request
     * @return the login response with token and user info
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        LoginResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
