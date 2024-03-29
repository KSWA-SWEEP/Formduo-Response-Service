package com.sweep.responseservice.web.controller;


import com.sweep.responseservice.service.surveys.SurveyRespService;
import com.sweep.responseservice.util.RequestUtil;
import com.sweep.responseservice.web.dto.survey_resps.ConvReqDto;
import com.sweep.responseservice.web.dto.survey_resps.ConvResDto;
import com.sweep.responseservice.web.dto.survey_resps.SurveyRespsRequestDto;
import com.sweep.responseservice.web.dto.survey_resps.SurveyRespsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "설문 응답", description = "설문 응답 관련 api 입니다.")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class SurveyRespApiController {

    private final SurveyRespService surveyRespService;


    @Operation(summary = "설문 응답 생성 요청", description = "설문에 대한 응답이 생성됩니다.")
    @PostMapping("/create")
    public String save(@RequestBody SurveyRespsRequestDto requestDto) {
        return surveyRespService.save(requestDto);
    }

    @Operation(summary = "설문 응답 조회 요청", description = "설문이 대한 특정 응답이 조회됩니다.")
    @GetMapping("/response/{id}")
    public SurveyRespsResponseDto findSurveyRespById (@PathVariable String id) {
        return surveyRespService.findById(id);
    }

    @Operation(summary = "설문 전체 응답 요청!!", description = "설문에 대한 전체응답정보를 요청합니다.")
    @GetMapping("/response/all/{svyId}")
    public List<SurveyRespsResponseDto> findAllRepsById (@PathVariable String svyId) {
        return surveyRespService.findAll(svyId);
    }

    @Operation(summary = "설문 발화 분석", description = "모든 질문들의 답변 입력 시 감정분석을 통해 제일 많이 나온 감정을 반환합니다.")
    @PostMapping("/response/conversation_analysis")
    public ConvResDto conv(@RequestBody ConvReqDto convDto) throws ParseException {
        return RequestUtil.restRequest(convDto.getMsg());
    }

}
