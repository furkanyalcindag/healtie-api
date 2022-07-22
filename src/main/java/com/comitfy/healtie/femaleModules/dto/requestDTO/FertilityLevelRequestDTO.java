package com.comitfy.healtie.femaleModules.dto.requestDTO;

import com.comitfy.healtie.femaleModules.model.enums.FertilityLevelEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FertilityLevelRequestDTO extends BaseDTO {
    private LocalDate startingDate;
    private FertilityLevelEnum fertilityLevelEnum;
}
