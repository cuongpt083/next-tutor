package com.cuongpt.nexttutor.repository;

import com.cuongpt.nexttutor.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {
    Optional<Quiz> findFirstByLevelAndSkillAndTopicAndIsActiveTrue(String level, String skill, String topic);

    List<Quiz> findByLevelAndSkillAndTopicAndIsActiveTrue(String level, String skill, String topic);
}
