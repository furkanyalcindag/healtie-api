package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Profession extends BaseEntity {

    @Column
    private String keyword;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;


}
