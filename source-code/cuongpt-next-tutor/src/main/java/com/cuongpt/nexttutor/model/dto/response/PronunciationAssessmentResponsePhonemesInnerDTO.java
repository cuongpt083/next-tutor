package com.cuongpt.nexttutor.model.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * PronunciationAssessmentResponsePhonemesInnerDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("PronunciationAssessmentResponse_phonemes_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class PronunciationAssessmentResponsePhonemesInnerDTO {

  private @Nullable String phoneme;

  private @Nullable Boolean isGood;

  private @Nullable String suggestion;

}

