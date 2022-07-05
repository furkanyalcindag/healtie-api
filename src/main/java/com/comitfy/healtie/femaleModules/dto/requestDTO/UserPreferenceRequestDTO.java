package com.comitfy.healtie.femaleModules.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class UserPreferenceRequestDTO extends BaseDTO {

    private UUID userUUID;

    private UUID preferenceUUID;

}
