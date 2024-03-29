package com.sweep.responseservice.web.dto.survey_resps;

import com.sweep.responseservice.domain.survey_resps.SurveyResps;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * A DTO for the {@link SurveyResps} entity
 */
@Getter
@NoArgsConstructor
public class SurveyRespsRequestDto{

    @Schema(description = "설문 아이디", defaultValue = "1")
    private String svyId;
    private List<Map<String, Object>> svyRespContent;

    @Builder
    public SurveyRespsRequestDto(String svyId, Instant svyRespDt, List<Map<String, Object>> svyRespContent){
        this.svyRespContent = svyRespContent;
    }

    public SurveyResps toEntity(String svyId) {
        return SurveyResps.builder()
                .svyId(svyId)
                .svyRespDt(Instant.now().plus(9, ChronoUnit.HOURS))
                .svyRespContent(svyRespContent)
                .build();
    }
}