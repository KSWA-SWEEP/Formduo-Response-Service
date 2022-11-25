package com.sweep.responseservice.domain.survey_resps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyRespsRepository extends JpaRepository<SurveyResps, Integer> {

    @Query(" select s from SurveyResps s where s.svyId = ?1 ")
    public List<SurveyResps> findAllBySvyId(Integer svyId);
}