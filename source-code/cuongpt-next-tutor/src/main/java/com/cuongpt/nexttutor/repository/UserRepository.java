package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for User entity operations.
 * Provides data access methods for user management.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by OAuth provider and OAuth ID.
     * 
     * @param oauthProvider The OAuth provider name (FACEBOOK, ZALO)
     * @param oauthId       The user ID from the OAuth provider
     * @return Optional containing the user if found
     */
    Optional<User> findByOauthProviderAndOauthId(String oauthProvider, String oauthId);
}
