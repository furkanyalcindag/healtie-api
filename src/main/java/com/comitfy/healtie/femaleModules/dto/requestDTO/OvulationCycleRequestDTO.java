package com.comitfy.healtie.femaleModules.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class OvulationCycleRequestDTO extends BaseDTO {

    private Date startingDate;

    private boolean activated;

    private boolean actuality;
}
