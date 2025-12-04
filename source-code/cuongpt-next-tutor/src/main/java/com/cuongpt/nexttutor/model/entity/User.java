package com.cuongpt.nexttutor.model.entity;

import com.cuongpt.nexttutor.model.enums.AuthProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * User entity representing a learner or parent in the system.
 * Maps to the 'users' table in the database.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    /** Unique identifier for the user */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /** OAuth provider used for authentication */
    @Column(name = "oauth_provider", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private AuthProvider oauthProvider;

    /** OAuth ID from the provider */
    @Column(name = "oauth_id", nullable = false)
    private String oauthId;

    /** Display name of the user */
    @Column(name = "display_name")
    private String displayName;

    /** Avatar URL */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /** User role (LEARNER, ADMIN, etc.) */
    @Column(name = "role", length = 20)
    private String role;

    /** Timestamp when the user was created */
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /** Timestamp of last login */
    @UpdateTimestamp
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}
