package com.comitfy.healtie.userModule.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.GenderEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class UserGenderRequestDTO extends BaseDTO {
    private GenderEnum genderEnum;

}
