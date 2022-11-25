package com.sweep.responseservice.service.surveys;

import com.sweep.responseservice.web.dto.surveys.SurveysResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(name = "survey-service")
public interface SurveyServiceClient {

    @GetMapping(value = "/api/v1/surveys/{id}")
    Optional<SurveysResponseDto> findById(@PathVariable Integer id);
}
