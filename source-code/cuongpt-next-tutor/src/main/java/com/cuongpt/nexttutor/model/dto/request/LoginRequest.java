package com.cuongpt.nexttutor.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for OAuth2 login.
 * Contains the OAuth provider name and access token for authentication.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    /**
     * OAuth provider name (FACEBOOK or ZALO).
     */
    @NotBlank(message = "Provider is required")
    private String provider;

    /**
     * Access token received from the OAuth provider SDK.
     */
    @NotBlank(message = "Access token is required")
    private String accessToken;
}
