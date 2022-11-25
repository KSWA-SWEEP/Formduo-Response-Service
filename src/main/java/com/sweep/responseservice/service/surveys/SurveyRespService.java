package com.sweep.responseservice.service.surveys;

import com.sweep.responseservice.domain.survey_resps.SurveyResps;
import com.sweep.responseservice.domain.survey_resps.SurveyRespsRepository;
import com.sweep.responseservice.service.kafka.KafkaProducer;
import com.sweep.responseservice.web.dto.survey_resps.SurveyRespsRequestDto;
import com.sweep.responseservice.web.dto.survey_resps.SurveyRespsResponseDto;
import com.sweep.responseservice.web.dto.surveys.SurveysResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class SurveyRespService {
    private final SurveyServiceClient surveysRepository;
    private final SurveyRespsRepository surveyRespsRepository;

    private final KafkaProducer kafkaProducer;

    @Transactional
    public Integer save(SurveyRespsRequestDto requestDto) {
        // 설문이 있는지 없는지 확인
        SurveysResponseDto surveys = surveysRepository.findById(requestDto.getSvyId())
                .orElseThrow(() -> new IllegalArgumentException("해당 설문이 없습니다. id = "+requestDto.getSvyId()));

        if(surveys.getSvyEndDt().isBefore(Instant.now()))
        {
            throw new IllegalArgumentException("설문 기간이 지났습니다.");
        }
        // 응답수가 최대 수를 넘었는지 확인
        if(surveys.getSvyRespMax() < surveys.getSvyRespCount()+1)
        {
            throw new IllegalArgumentException("설문 응답자 수가 초과되었습니다.");
        }
        //kafka send
        kafkaProducer.send("survey-response-topic", requestDto);
//            surveys.countUp(surveys.getSvyRespCount()+1);

        return surveyRespsRepository.save(requestDto.toEntity()).getId();
        // 기간이 지났는지 확인
    }

    @Transactional(readOnly = true)
    public SurveyRespsResponseDto findById(int id){
        SurveyResps entity = surveyRespsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 응답이 없습니다. id ="+ id));
        return new SurveyRespsResponseDto(entity);}


    @Transactional(readOnly = true)
    public List<SurveyRespsResponseDto> findAll(int svyId) {
        List<SurveyResps> list = surveyRespsRepository.findAllBySvyId(svyId);
        return list.stream().map(SurveyRespsResponseDto::new).collect(Collectors.toList());
    }
}
