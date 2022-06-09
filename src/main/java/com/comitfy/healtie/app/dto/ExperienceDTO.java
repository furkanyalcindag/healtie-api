package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ExperienceDTO extends BaseDTO {

    private String title;

    private String workedPlace;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
