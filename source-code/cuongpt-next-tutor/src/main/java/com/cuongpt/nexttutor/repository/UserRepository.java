package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.User;
import com.cuongpt.nexttutor.model.enums.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for User entity operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by OAuth provider and OAuth ID.
     * 
     * @param provider the OAuth provider
     * @param oauthId  the OAuth ID from the provider
     * @return an Optional containing the user if found
     */
    Optional<User> findByOauthProviderAndOauthId(AuthProvider provider, String oauthId);
}
