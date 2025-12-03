package com.cuongpt.nexttutor.model.dto.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;


import jakarta.annotation.Generated;

/**
 * GetHintRequestDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("GetHintRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class GetHintRequestDTO {

  private @Nullable String context;

}

