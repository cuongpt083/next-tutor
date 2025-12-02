package com.cuongpt.nexttutor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entity representing a user in the Next Tutor system.
 * Users authenticate via OAuth2 providers (Facebook, Zalo) and their
 * information
 * is synchronized from the social media platforms.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * OAuth provider name (FACEBOOK, ZALO).
     */
    @Column(name = "oauth_provider", nullable = false, length = 50)
    private String oauthProvider;

    /**
     * User ID from the OAuth provider.
     */
    @Column(name = "oauth_id", nullable = false)
    private String oauthId;

    /**
     * Display name synchronized from OAuth provider.
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * Avatar URL synchronized from OAuth provider.
     */
    @Column(name = "avatar_url", columnDefinition = "TEXT")
    private String avatarUrl;

    /**
     * Timestamp when the user account was created.
     */
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    /**
     * Timestamp of the user's last login.
     */
    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }
        if (lastLogin == null) {
            lastLogin = OffsetDateTime.now();
        }
    }
}
