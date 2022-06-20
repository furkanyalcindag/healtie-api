package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class ContractDTO extends BaseDTO {

    private String key;

    private String title;

    private String content;

    private boolean isRequired;
}
