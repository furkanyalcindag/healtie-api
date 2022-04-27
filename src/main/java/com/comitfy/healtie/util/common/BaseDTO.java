package com.comitfy.healtie.util.common;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class BaseDTO {
    private UUID uuid;
    @JsonIgnore
    private LanguageEnum languageEnum;
}
