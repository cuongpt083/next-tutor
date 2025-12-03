package com.cuongpt.nexttutor.model.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;


import jakarta.annotation.Generated;

/**
 * SubmitQuizResponseDetailsInnerDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("SubmitQuizResponse_details_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class SubmitQuizResponseDetailsInnerDTO {

  private @Nullable String questionId;

  private @Nullable Boolean isCorrect;

  private @Nullable String explanation;

}

