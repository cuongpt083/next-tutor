package com.cuongpt.nexttutor.bff.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for successful login.
 * Contains the JWT token and user information for frontend consumption.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    /**
     * JWT token for subsequent authenticated requests.
     * Frontend should include this in Authorization header as "Bearer {token}".
     */
    private String token;

    /**
     * User information after successful authentication.
     */
    private UserInfo user;

    /**
     * Nested class containing user information.
     * Separated from the entity to control what data is exposed to frontend.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        /**
         * User's unique identifier (UUID as string).
         */
        private String id;

        /**
         * User's display name from OAuth provider.
         */
        private String displayName;

        /**
         * URL to user's avatar image from OAuth provider.
         */
        private String avatarUrl;

        /**
         * User's role in the system.
         * Currently always "LEARNER" for MVP.
         */
        private String role;
    }
}
