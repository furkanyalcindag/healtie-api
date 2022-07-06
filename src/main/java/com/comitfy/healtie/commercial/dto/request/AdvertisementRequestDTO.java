package com.comitfy.healtie.commercial.dto.request;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AdvertisementRequestDTO extends BaseDTO {

    private String location;
    private float width;
    private float height;
    private float price;
    private float taxRatio;
    @JsonIgnore
    private LanguageEnum languageEnum;
}
