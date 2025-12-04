package com.cuongpt.nexttutor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_progress")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "skill_type", nullable = false)
    private String skillType;

    @Column(name = "total_minutes")
    private Integer totalMinutes;

    @Column(name = "total_sessions")
    private Integer totalSessions;

    @Column(name = "average_score")
    private Float averageScore;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() {
        lastUpdated = LocalDateTime.now();
        if (totalMinutes == null)
            totalMinutes = 0;
        if (totalSessions == null)
            totalSessions = 0;
        if (averageScore == null)
            averageScore = 0.0f;
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
