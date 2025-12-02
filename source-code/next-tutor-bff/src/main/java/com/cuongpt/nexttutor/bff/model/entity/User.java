package com.cuongpt.nexttutor.bff.model.entity;

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
 * Database Table: users
 * Primary Key: id (UUID)
 * Unique Constraint: (oauth_provider, oauth_id)
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
     * Generated automatically using UUID strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * OAuth provider name (FACEBOOK, ZALO).
     * Used in combination with oauth_id to uniquely identify users.
     */
    @Column(name = "oauth_provider", nullable = false, length = 50)
    private String oauthProvider;

    /**
     * User ID from the OAuth provider.
     * Combined with oauth_provider forms a unique constraint.
     */
    @Column(name = "oauth_id", nullable = false)
    private String oauthId;

    /**
     * Display name synchronized from OAuth provider.
     * May be updated when user logs in with fresh OAuth data.
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * Avatar URL synchronized from OAuth provider.
     * Points to the user's profile picture from the social platform.
     */
    @Column(name = "avatar_url", columnDefinition = "TEXT")
    private String avatarUrl;

    /**
     * Timestamp when the user account was created.
     * Set automatically on first insert.
     */
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    /**
     * Timestamp of the user's last login.
     * Updated each time the user successfully authenticates.
     */
    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    /**
     * JPA lifecycle callback executed before persisting a new entity.
     * Initializes timestamps if not already set.
     */
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
