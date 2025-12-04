package com.cuongpt.nexttutor.service;

import com.cuongpt.nexttutor.model.dto.QuestionDTO;
import com.cuongpt.nexttutor.model.dto.QuizDTO;
import com.cuongpt.nexttutor.model.dto.request.SubmitQuizRequestAnswersInnerDTO;
import com.cuongpt.nexttutor.model.dto.response.SubmitQuizResponseDTO;
import com.cuongpt.nexttutor.model.dto.response.SubmitQuizResponseDetailsInnerDTO;
import com.cuongpt.nexttutor.model.entity.Question;
import com.cuongpt.nexttutor.model.entity.Quiz;
import com.cuongpt.nexttutor.repository.QuizRepository;
import com.cuongpt.nexttutor.utils.ContextManager;
import com.cuongpt.nexttutor.utils.ProgressManager;
import com.cuongpt.nexttutor.utils.RC4Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final AiService aiService;
    private final ContextManager contextManager;
    private final ProgressManager progressManager;
    private final RC4Utils rc4Utils;
    private final ObjectMapper objectMapper;

    @Transactional
    public QuizDTO getQuiz(String level, String skill, String topic) {
        return quizRepository.findFirstByLevelAndSkillAndTopicAndIsActiveTrue(level, skill, topic)
                .map(this::mapToDTO)
                .orElseGet(() -> createNewQuiz(level, skill, topic));
    }

    @Transactional(readOnly = true)
    public QuizDTO getQuizById(UUID quizId) {
        return quizRepository.findById(quizId)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    @Transactional
    public QuizDTO updateQuiz(UUID quizId, QuizDTO quizDTO) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Update logic - for now just update isActive if present
        if (quizDTO.getIsActive() != null) {
            quiz.setIsActive(quizDTO.getIsActive());
        }
        // Could update questions too if needed, but usually we don't update generated
        // quizzes heavily.

        return mapToDTO(quizRepository.save(quiz));
    }

    @Transactional
    public void deleteQuiz(UUID quizId) {
        if (!quizRepository.existsById(quizId)) {
            throw new RuntimeException("Quiz not found");
        }
        quizRepository.deleteById(quizId);
    }

    @Transactional
    public SubmitQuizResponseDTO submitQuiz(UUID quizId, List<SubmitQuizRequestAnswersInnerDTO> answers, UUID userId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        int score = 0;
        List<SubmitQuizResponseDetailsInnerDTO> details = new ArrayList<>();

        for (SubmitQuizRequestAnswersInnerDTO answer : answers) {
            Question question = quiz.getQuestions().stream()
                    .filter(q -> q.getId().equals(answer.getQuestionId()))
                    .findFirst()
                    .orElse(null);

            if (question != null) {
                boolean isCorrect = question.getSolution().equalsIgnoreCase(answer.getSelectedOption());
                if (isCorrect) {
                    score++;
                }
                details.add(SubmitQuizResponseDetailsInnerDTO.builder()
                        .questionId(question.getId())
                        .isCorrect(isCorrect)
                        .explanation(question.getExplanation())
                        .build());
            }
        }

        progressManager.updateProgress(userId, quiz.getSkill(), score, quiz.getQuestions().size());

        return SubmitQuizResponseDTO.builder()
                .score(score)
                .totalQuestions(quiz.getQuestions().size())
                .details(details)
                .build();
    }

    private QuizDTO createNewQuiz(String level, String skill, String topic) {
        String context = contextManager.createContext(level, skill, topic, 10); // Default 10 questions
        String jsonResponse = aiService.generateQuiz(context);

        List<Question> questions;
        try {
            questions = objectMapper.readValue(jsonResponse, new TypeReference<List<Question>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI response", e);
        }

        Quiz quiz = Quiz.builder()
                .level(level)
                .skill(skill)
                .topic(topic)
                .isActive(true)
                .questions(questions)
                .build();

        quiz = quizRepository.save(quiz);
        return mapToDTO(quiz);
    }

    private QuizDTO mapToDTO(Quiz quiz) {
        List<QuestionDTO> questionDTOs = quiz.getQuestions().stream()
                .map(q -> QuestionDTO.builder()
                        .id(q.getId())
                        .type(QuestionDTO.TypeEnum.fromValue(q.getType()))
                        .content(q.getContent())
                        .options(q.getOptions())
                        .solution(rc4Utils.encrypt(q.getSolution()))
                        .explanation(q.getExplanation())
                        .hint(q.getHint())
                        .audioUrl(q.getAudioUrl())
                        .build())
                .collect(Collectors.toList());

        return QuizDTO.builder()
                .quizId(quiz.getId())
                .isActive(quiz.getIsActive())
                .questions(questionDTOs)
                .build();
    }
}
