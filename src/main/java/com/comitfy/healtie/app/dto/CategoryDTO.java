package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class CategoryDTO extends BaseDTO {

   private String name;

   private LanguageEnum languageEnum;

   private List<CategoryDTO> parentList;

   private List<ArticleDTO> articleDTOSet;

}
