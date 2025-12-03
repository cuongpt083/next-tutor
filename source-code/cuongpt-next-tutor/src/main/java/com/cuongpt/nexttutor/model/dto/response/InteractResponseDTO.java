package com.cuongpt.nexttutor.model.dto.response;

import com.cuongpt.nexttutor.model.dto.AiMessageContentDTO;
import com.cuongpt.nexttutor.model.dto.FeedbackDTO;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * InteractResponseDTO
 */
@lombok.Builder
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("InteractResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class InteractResponseDTO {

  private @Nullable AiMessageContentDTO aiResponse;

  private @Nullable FeedbackDTO feedback;

}

