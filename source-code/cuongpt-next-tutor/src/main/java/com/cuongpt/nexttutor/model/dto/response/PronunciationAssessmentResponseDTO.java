package com.cuongpt.nexttutor.model.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * PronunciationAssessmentResponseDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("PronunciationAssessmentResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class PronunciationAssessmentResponseDTO {

  private @Nullable Integer score;

  @lombok.Builder.Default
  @Valid
  private List<@Valid PronunciationAssessmentResponsePhonemesInnerDTO> phonemes = new ArrayList<>();

  private @Nullable String overallFeedback;

}

