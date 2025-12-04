package com.cuongpt.nexttutor.utils;

import com.cuongpt.nexttutor.model.entity.UserProgress;
import com.cuongpt.nexttutor.repository.UserProgressRepository;
import com.cuongpt.nexttutor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProgressManager {

    private final UserProgressRepository userProgressRepository;
    private final UserRepository userRepository;

    @Transactional
    public void updateProgress(UUID userId, String skillType, int score, int totalQuestions) {
        UserProgress progress = userProgressRepository.findByUserIdAndSkillType(userId, skillType)
                .orElse(UserProgress.builder()
                        .user(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found")))
                        .skillType(skillType)
                        .totalMinutes(0)
                        .totalSessions(0)
                        .averageScore(0.0f)
                        .build());

        // Update logic
        int newSessions = progress.getTotalSessions() + 1;
        float currentTotalScore = progress.getAverageScore() * progress.getTotalSessions();
        float sessionScore = ((float) score / totalQuestions) * 100;

        float newAverage = (currentTotalScore + sessionScore) / newSessions;

        progress.setTotalSessions(newSessions);
        progress.setAverageScore(newAverage);

        userProgressRepository.save(progress);
    }
}
