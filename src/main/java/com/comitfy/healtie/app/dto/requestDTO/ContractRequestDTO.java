package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ContractRequestDTO extends BaseDTO {
    private String key;

    private String title;

    private String content;

    private boolean isRequired;


    @JsonIgnore
    private LanguageEnum languageEnum;

    private boolean isActive;
}
