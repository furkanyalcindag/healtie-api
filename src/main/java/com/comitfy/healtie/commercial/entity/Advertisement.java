package com.comitfy.healtie.commercial.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "advertisement_uuid"
        )
)
public class Advertisement extends BaseEntity {

    @Column
    private String location;

    @Column
    private float width;

    @Column
    private float height;

    @Column
    private float price;

    @Column
    private float taxRatio;


    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;


}
