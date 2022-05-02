package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class ProfessionTranslationRequestDTO extends BaseDTO {

    private String name;
    private LanguageEnum languageEnum;
}
