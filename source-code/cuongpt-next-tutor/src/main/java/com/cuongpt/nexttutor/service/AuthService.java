package com.cuongpt.nexttutor.service;

import com.cuongpt.nexttutor.model.dto.UserDTO;
import com.cuongpt.nexttutor.model.dto.request.LoginRequestDTO;
import com.cuongpt.nexttutor.model.dto.response.LoginResponseDTO;
import com.cuongpt.nexttutor.model.entity.User;
import com.cuongpt.nexttutor.model.enums.AuthProvider;
import com.cuongpt.nexttutor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for authentication operations.
 * Handles user login via OAuth providers and token generation.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    /**
     * Authenticates a user via OAuth provider.
     * Creates a new user if they don't exist.
     * 
     * @param request the login request containing provider and access token
     * @return the login response with JWT token and user info
     */
    @Transactional
    public LoginResponseDTO login(LoginRequestDTO request) {
        // Mock OAuth validation - in production, verify token with provider API
        String oauthId = generateMockOAuthId(request.getAccessToken());
        String displayName = "User " + request.getProvider().getValue();

        // Convert DTO enum to entity enum
        AuthProvider provider = AuthProvider.valueOf(request.getProvider().getValue());

        // Find or create user
        User user = userRepository.findByOauthProviderAndOauthId(
                provider,
                oauthId)
                .orElseGet(() -> createNewUser(provider, oauthId, displayName));

        // Generate JWT token
        String token = jwtService.generateToken(user.getId());

        // Build response
        return LoginResponseDTO.builder()
                .token(token)
                .user(mapToUserDTO(user))
                .build();
    }

    /**
     * Creates a new user entity.
     * 
     * @param provider    OAuth provider
     * @param oauthId     OAuth ID
     * @param displayName display name
     * @return the created user
     */
    private User createNewUser(AuthProvider provider, String oauthId, String displayName) {
        User newUser = User.builder()
                .oauthProvider(provider)
                .oauthId(oauthId)
                .displayName(displayName)
                .role("LEARNER")
                .avatarUrl("https://api.dicebear.com/7.x/avataaars/svg?seed=" + oauthId)
                .build();
        return userRepository.save(newUser);
    }

    /**
     * Maps User entity to UserDTO.
     * 
     * @param user the user entity
     * @return the user DTO
     */
    private UserDTO mapToUserDTO(User user) {
        UserDTO.UserDTOBuilder builder = UserDTO.builder()
                .id(user.getId())
                .displayName(user.getDisplayName())
                .avatarUrl(user.getAvatarUrl());

        if (user.getRole() != null) {
            try {
                builder.role(UserDTO.RoleEnum.fromValue(user.getRole()));
            } catch (IllegalArgumentException e) {
                builder.role(UserDTO.RoleEnum.LEARNER);
            }
        }

        return builder.build();
    }

    /**
     * Generates a mock OAuth ID for testing.
     * In production, this would be replaced with actual OAuth validation.
     * 
     * @param accessToken the access token
     * @return a mock OAuth ID
     */
    private String generateMockOAuthId(String accessToken) {
        return "mock_" + Math.abs(accessToken.hashCode());
    }
}
