package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class ExperienceRequestDTO extends BaseDTO {
    private String workedPlace;

    private String description;

    private Date startDate;

    private Date endDate;
}
