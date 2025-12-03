package com.cuongpt.nexttutor.model.dto;

import java.net.URI;
import java.util.Objects;
import com.cuongpt.nexttutor.model.dto.SubmitQuizResponseDetailsInnerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
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

