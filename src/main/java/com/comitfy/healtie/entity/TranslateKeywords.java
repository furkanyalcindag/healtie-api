package com.comitfy.healtie.entity;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class TranslateKeywords extends BaseEntity {

    private String keyword;
    private String type;
    private String languageCode;

}
