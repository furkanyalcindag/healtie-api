package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class ArticleDTO extends BaseDTO {

    private String name;
    private String title;
    private LanguageEnum languageEnum;

    @ElementCollection
    private List<String> tag;



}
