package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.LearningSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for LearningSession entity operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Repository
public interface LearningSessionRepository extends JpaRepository<LearningSession, UUID> {
}
