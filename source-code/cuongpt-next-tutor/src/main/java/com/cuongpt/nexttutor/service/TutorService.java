package com.cuongpt.nexttutor.service;

import com.cuongpt.nexttutor.model.dto.TutorDTO;
import com.cuongpt.nexttutor.model.entity.Tutor;
import com.cuongpt.nexttutor.repository.TutorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for tutor management operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    /**
     * Initializes default tutors if the database is empty.
     */
    @PostConstruct
    public void initializeDefaultTutors() {
        if (tutorRepository.count() == 0) {
            createDefaultTutors();
        }
    }

    /**
     * Retrieves all available tutors.
     * 
     * @return list of tutor DTOs
     */
    public List<TutorDTO> getAllTutors() {
        return tutorRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Creates default tutors for the system.
     */
    private void createDefaultTutors() {
        tutorRepository.save(Tutor.builder()
                .id("tutor_bear")
                .name("Mr. Bear")
                .description("Friendly and patient, loves storytelling")
                .systemPrompt(
                        "You are Mr. Bear, a friendly and patient English tutor. You love telling stories and making learning fun.")
                .avatarUrl("/assets/tutors/bear.png")
                .build());

        tutorRepository.save(Tutor.builder()
                .id("tutor_rabbit")
                .name("Miss Rabbit")
                .description("Energetic and encouraging, great with pronunciation")
                .systemPrompt(
                        "You are Miss Rabbit, an energetic and encouraging English tutor. You excel at helping students with pronunciation.")
                .avatarUrl("/assets/tutors/rabbit.png")
                .build());

        tutorRepository.save(Tutor.builder()
                .id("tutor_robot")
                .name("Robo Teacher")
                .description("Systematic and clear, perfect for grammar")
                .systemPrompt(
                        "You are Robo Teacher, a systematic and clear English tutor. You are excellent at explaining grammar rules.")
                .avatarUrl("/assets/tutors/robot.png")
                .build());
    }

    /**
     * Maps Tutor entity to TutorDTO.
     * 
     * @param tutor the tutor entity
     * @return the tutor DTO
     */
    private TutorDTO mapToDTO(Tutor tutor) {
        return TutorDTO.builder()
                .id(tutor.getId())
                .name(tutor.getName())
                .description(tutor.getDescription())
                .avatarUrl(tutor.getAvatarUrl())
                .personalityPrompt(tutor.getSystemPrompt())
                .build();
    }
}
