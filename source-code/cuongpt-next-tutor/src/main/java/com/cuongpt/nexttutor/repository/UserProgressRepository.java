package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, UUID> {
    Optional<UserProgress> findByUserIdAndSkillType(UUID userId, String skillType);
}
