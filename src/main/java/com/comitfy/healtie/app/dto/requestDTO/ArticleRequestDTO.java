package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class ArticleRequestDTO extends BaseDTO {
    private String name;
    private String title;

    @ElementCollection
    private List<String> tag;
    @JsonIgnore
    private LanguageEnum languageEnum;
}
