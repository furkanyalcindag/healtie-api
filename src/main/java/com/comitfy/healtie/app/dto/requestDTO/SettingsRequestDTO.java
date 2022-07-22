package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class SettingsRequestDTO extends BaseDTO {

    private String key;
    private String value;
    private boolean isCurrent;

}
