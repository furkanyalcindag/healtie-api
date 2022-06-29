package com.comitfy.healtie.femaleModules.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class OvulationCycleDTO extends BaseDTO {
    private Date startingDate;

    private boolean activated;

    private boolean actuality;
}
