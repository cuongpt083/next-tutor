package com.cuongpt.nexttutor.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO for successful login.
 * Contains the JWT token and user information.
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
     */
    private String token;

    /**
     * User information after successful authentication.
     */
    private UserInfo user;

    /**
     * Nested class containing user information.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        /**
         * User's unique identifier.
         */
        private String id;

        /**
         * User's display name.
         */
        private String displayName;

        /**
         * URL to user's avatar image.
         */
        private String avatarUrl;

        /**
         * User's role in the system (e.g., LEARNER).
         */
        private String role;
    }
}
