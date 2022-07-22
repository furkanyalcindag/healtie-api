package com.comitfy.healtie.femaleModules.dto;

import com.comitfy.healtie.femaleModules.entity.FertilityLevel;
import com.comitfy.healtie.femaleModules.model.enums.FertilityLevelEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class OvulationCycleDTO extends BaseDTO {

    private LocalDate startingDate;
    private LocalDate estimatedDate;

    private boolean activated;

    private boolean actuality;

    private Set<FertilityLevelDTO> fertilityLevels;


}
