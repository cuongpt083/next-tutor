package com.cuongpt.nexttutor.controller;

import com.cuongpt.nexttutor.model.dto.QuizDTO;
import com.cuongpt.nexttutor.model.dto.request.SubmitQuizRequestDTO;
import com.cuongpt.nexttutor.model.dto.response.SubmitQuizResponseDTO;
import com.cuongpt.nexttutor.service.JwtService;
import com.cuongpt.nexttutor.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<QuizDTO> getQuiz(
            @RequestParam String level,
            @RequestParam String skill,
            @RequestParam String topic) {
        return ResponseEntity.ok(quizService.getQuiz(level, skill, topic));
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable UUID quizId) {
        return ResponseEntity.ok(quizService.getQuizById(quizId));
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<QuizDTO> updateQuiz(
            @PathVariable UUID quizId,
            @RequestBody QuizDTO quizDTO) {
        return ResponseEntity.ok(quizService.updateQuiz(quizId, quizDTO));
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable UUID quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<SubmitQuizResponseDTO> submitQuiz(
            @PathVariable UUID quizId,
            @RequestBody SubmitQuizRequestDTO request,
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        UUID userId;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                userId = jwtService.extractUserId(token);
            } catch (Exception e) {
                // Fallback or throw unauthorized
                // For MVP, if token is invalid, we might want to throw 401
                // But let's assume valid token or fallback for dev
                throw new RuntimeException("Invalid token");
            }
        } else {
            // Fallback for dev/testing without auth
            throw new RuntimeException("Authorization header missing");
        }

        return ResponseEntity.ok(quizService.submitQuiz(quizId, request.getAnswers(), userId));
    }
}
