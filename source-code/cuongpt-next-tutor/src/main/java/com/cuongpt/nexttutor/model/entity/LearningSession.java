package com.cuongpt.nexttutor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entity representing a learning session in the Next Tutor system.
 * A session tracks a user's interaction with an AI tutor on a specific topic.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Entity
@Table(name = "learning_sessions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LearningSession {

    /**
     * Unique identifier for the learning session.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Reference to the user participating in this session.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Reference to the AI tutor conducting this session.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    /**
     * Reference to the topic being covered in this session.
     */
    @Column(name = "topic_id", length = 50)
    private String topicId;

    /**
     * Mode of the learning session (SPEAKING, ROLE_PLAY, QUIZ).
     */
    @Column(nullable = false, length = 20)
    private String mode;

    /**
     * Current status of the session (ACTIVE, COMPLETED).
     */
    @Column(length = 20)
    private String status;

    /**
     * Timestamp when the session started.
     */
    @Column(name = "start_time")
    private OffsetDateTime startTime;

    /**
     * Timestamp when the session ended.
     */
    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @PrePersist
    protected void onCreate() {
        if (startTime == null) {
            startTime = OffsetDateTime.now();
        }
        if (status == null) {
            status = "ACTIVE";
        }
    }
}
