package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class ContractActiveDTO extends BaseDTO {
    private String key;

    private String title;

    private boolean isRequired;

    private boolean isActive;
}
