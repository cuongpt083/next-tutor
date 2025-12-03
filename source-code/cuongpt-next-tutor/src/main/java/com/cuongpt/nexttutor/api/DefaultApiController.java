package com.cuongpt.nexttutor.api;

import com.cuongpt.nexttutor.model.dto.ApiV1SessionsSessionIdInteractPostRequestDTO;
import com.cuongpt.nexttutor.model.dto.GetHintRequestDTO;
import com.cuongpt.nexttutor.model.dto.GetHintResponseDTO;
import com.cuongpt.nexttutor.model.dto.InteractRequestDTO;
import com.cuongpt.nexttutor.model.dto.InteractResponseDTO;
import com.cuongpt.nexttutor.model.dto.LoginRequestDTO;
import com.cuongpt.nexttutor.model.dto.LoginResponseDTO;
import com.cuongpt.nexttutor.model.dto.PronunciationAssessmentResponseDTO;
import com.cuongpt.nexttutor.model.dto.QuizDTO;
import com.cuongpt.nexttutor.model.dto.StartSessionRequestDTO;
import com.cuongpt.nexttutor.model.dto.StartSessionResponseDTO;
import com.cuongpt.nexttutor.model.dto.SttResponseDTO;
import com.cuongpt.nexttutor.model.dto.SubmitQuizRequestDTO;
import com.cuongpt.nexttutor.model.dto.SubmitQuizResponseDTO;
import com.cuongpt.nexttutor.model.dto.TtsRequestDTO;
import com.cuongpt.nexttutor.model.dto.TutorDTO;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T18:26:26.686856118+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
@Controller
@RequestMapping("${openapi.nextTutor.base-path:}")
public class DefaultApiController implements DefaultApi {

    private final NativeWebRequest request;

    @Autowired
    public DefaultApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
