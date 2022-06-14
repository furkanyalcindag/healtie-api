package com.comitfy.healtie.userModule.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.AgeRangeEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class UserAgeRangeRequestDTO extends BaseDTO {

    private AgeRangeEnum ageRangeEnum;
}
