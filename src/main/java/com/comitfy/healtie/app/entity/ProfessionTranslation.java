package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "profession_translation_uuid"
        )
)
public class ProfessionTranslation extends BaseEntity {

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;

    @ManyToOne
    private Profession profession;


}
