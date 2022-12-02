package com.sweep.responseservice.web.dto.surveys;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * A DTO for the {@link Surveys} entity
 */
@Getter
@Data
@NoArgsConstructor
public class SurveysResponseDto  {

    private  String id;
    private  String regUser;
    private  String svySt;
    private  String svyTitle;
    private  String svyIntro;
    private List<Map<String, Object>> svyContent;
    private  Instant svyStartDt;
    private  Instant svyEndDt;
    private  Character delYn;
    private  String svyEndMsg;
    private  Instant svyRegDt;

    private Integer svyRespMax;
    private Integer svyRespCount;
    private String svyType;

    // 클라이언트가 요청했을 때 보여질 애들을 정합시다~.

    public SurveysResponseDto(String svySt, String svyTitle,
                              String svyIntro, List<Map<String, Object>> svyContent, char delYn,
                              String svyEndMsg, int svyRespCount, int svyRespMax,
                              Instant svyRegDt, Instant svyEndDt, Instant svyStartDt, String svyType){
        this.svySt = svySt;
        this.svyTitle = svyTitle;
        this.svyIntro = svyIntro;
        this.svyContent = svyContent;
        this.delYn = delYn;
        this.svyEndMsg = svyEndMsg;
        this.svyStartDt = svyStartDt;
        this.svyEndDt = svyEndDt;
        this.svyType = svyType;
        this.svyRespMax = svyRespMax;
        this.svyRespCount = svyRespCount;
        this.svyRegDt = svyRegDt;
    }



//    public Surveys toEntity() {
//        return Surveys.builder()
//                .regUser(regUser)
//                .svyTitle(svyTitle)
//                .svyIntro(svyIntro)
//                .svyContent(svyContent)
//                .svyEndMsg(svyEndMsg)
//                .delYn(delYn)
//                .build();
//    }
}