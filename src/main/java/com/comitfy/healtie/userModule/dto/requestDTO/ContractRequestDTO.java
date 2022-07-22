package com.comitfy.healtie.userModule.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ContractRequestDTO extends BaseDTO {
    private String key;

    private String title;

    private String content;

    private boolean isRequired;


    @JsonIgnore
    private LanguageEnum languageEnum;

    private boolean isActive;

    private List<UUID> roleList;
}
