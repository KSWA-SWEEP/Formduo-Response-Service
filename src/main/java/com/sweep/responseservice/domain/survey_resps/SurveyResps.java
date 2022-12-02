package com.sweep.responseservice.domain.survey_resps;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
//@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
@Document(collection = "responses")
public class SurveyResps {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

//    @Column(name = "SVY_ID")
    @Field("SVY_ID")
    private String svyId;

//    @Column(name = "SVY_RESP_DT")
    @Field("SVY_RESP_DT")
    private Instant svyRespDt;

    @Type(type="json")
//    @Column(name = "SVY_RESP_CONTENT", nullable = false, columnDefinition = "json")
    @Field("SVY_RESP_CONTENT")
    private List<Map<String, Object>> svyRespContent;

    @Builder
    public SurveyResps(Instant svyRespDt, String svyId,
                       List<Map<String, Object>> svyRespContent)
    {
        this.svyRespDt = svyRespDt;
        this.svyRespContent = svyRespContent;
        this.svyId = svyId;
    }


}