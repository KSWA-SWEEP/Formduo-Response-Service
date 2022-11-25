package com.sweep.responseservice.web.dto.survey_resps;

import lombok.*;

/**
 * A DTO for the {@link Users} entity
 */
@Setter
@Getter
@Data
public class ConvReqDto {
//    @Schema(description = "고유 아이디")
//    private final Integer id
    private String msg;
}