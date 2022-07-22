package com.comitfy.healtie.femaleModules.dto;

import com.comitfy.healtie.femaleModules.model.enums.FertilityLevelEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FertilityLevelDTO extends BaseDTO {

    private LocalDate date;
    private FertilityLevelEnum fertilityLevelEnum;
}
