package com.cuongpt.nexttutor.model.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;


import jakarta.annotation.Generated;

/**
 * SubmitQuizResponseDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("SubmitQuizResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class SubmitQuizResponseDTO {

  private @Nullable Integer score;

  private @Nullable Integer totalQuestions;

  @lombok.Builder.Default
  @Valid
  private List<@Valid SubmitQuizResponseDetailsInnerDTO> details = new ArrayList<>();

}

