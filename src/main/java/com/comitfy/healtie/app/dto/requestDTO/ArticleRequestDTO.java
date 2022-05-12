package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.UUID;

@Data
public class ArticleRequestDTO extends BaseDTO {
    private String name;
    private String title;

    @ElementCollection
    private List<String> tag;
    @JsonIgnore
    private LanguageEnum languageEnum;

    //private List<Category> categoryList;
}
