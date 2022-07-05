package com.comitfy.healtie.femaleModules.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class UserPreferenceDTO extends BaseDTO {

    private UUID userUUID;

    private UUID preferenceUUID;
}
