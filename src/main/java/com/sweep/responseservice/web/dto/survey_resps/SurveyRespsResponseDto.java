package com.sweep.responseservice.web.dto.survey_resps;

import com.sweep.responseservice.domain.survey_resps.SurveyResps;
import com.sweep.responseservice.web.dto.surveys.SurveysResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * A DTO for the {@link SurveyResps} entity
 */
@Getter
@NoArgsConstructor
public class SurveyRespsResponseDto {
    private String id;
    private String svyId;
    private Integer svyRespsCount;

    private Integer svyRespsMax;
    private Instant svyRespDt;
    private List<Map<String, Object>> svyRespContent;

    private String svyType;


    public SurveyRespsResponseDto(SurveyResps entity){
        this.id = entity.getId();
        this.svyId = entity.getSvyId();

//        this.svyRespsCount = surveys.getSvyRespCount();
//        this.svyRespsMax = surveys.getSvyRespMax();
        this.svyRespDt = entity.getSvyRespDt();
        this.svyRespContent = entity.getSvyRespContent();
//        this.svyType = surveys.getSvyType();
    }

    public void SurveyContentsUpdate(SurveysResponseDto entity){
        this.svyRespsCount = entity.getSvyRespCount();
        this.svyRespsMax = entity.getSvyRespMax();
        this.svyType = entity.getSvyType();
    }
}