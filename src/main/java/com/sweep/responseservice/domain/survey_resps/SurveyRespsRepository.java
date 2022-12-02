package com.sweep.responseservice.domain.survey_resps;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SurveyRespsRepository extends MongoRepository<SurveyResps, String> {

//    select s from SurveyResps s where s.svyId = ?1
    @Query("{'svyId' :  ?0} ")
    public List<SurveyResps> findAllBySvyId(String svyId);
}