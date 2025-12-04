package com.cuongpt.nexttutor.controller;

import com.cuongpt.nexttutor.model.dto.TutorDTO;
import com.cuongpt.nexttutor.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for tutor operations.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/tutors")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    /**
     * Retrieves all available tutors.
     * 
     * @return list of tutors
     */
    @GetMapping
    public ResponseEntity<List<TutorDTO>> getAllTutors() {
        return ResponseEntity.ok(tutorService.getAllTutors());
    }
}
