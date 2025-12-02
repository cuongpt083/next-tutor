package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Tutor entity operations.
 * Provides data access methods for AI tutor management.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Repository
public interface TutorRepository extends JpaRepository<Tutor, String> {
}
