package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class SettingsDTO extends BaseDTO {

    private String key;
    private String value;
    private Boolean isCurrent;
}
