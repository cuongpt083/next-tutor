package com.cuongpt.nexttutor.model.dto;

import java.net.URI;
import java.util.Objects;
import com.cuongpt.nexttutor.model.dto.SubmitQuizRequestAnswersInnerDTO;
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
 * SubmitQuizRequestDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("SubmitQuizRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class SubmitQuizRequestDTO {

  @lombok.Builder.Default
  @Valid
  private List<@Valid SubmitQuizRequestAnswersInnerDTO> answers = new ArrayList<>();

}

