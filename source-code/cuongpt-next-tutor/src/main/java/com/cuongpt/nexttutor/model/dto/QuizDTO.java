package com.cuongpt.nexttutor.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;


import jakarta.annotation.Generated;

/**
 * QuizDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("Quiz")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class QuizDTO {

  private @Nullable UUID quizId;

  @lombok.Builder.Default
  @Valid
  private List<@Valid QuestionDTO> questions = new ArrayList<>();

}

