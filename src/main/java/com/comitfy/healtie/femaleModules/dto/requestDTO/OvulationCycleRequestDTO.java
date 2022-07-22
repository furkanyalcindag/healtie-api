package com.comitfy.healtie.femaleModules.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OvulationCycleRequestDTO extends BaseDTO {

    private LocalDate startingDate;
    private LocalDate estimatedDate;

    private boolean activated;

    private boolean actuality;
}
