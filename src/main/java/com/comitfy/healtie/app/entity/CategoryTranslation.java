package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class CategoryTranslation extends BaseEntity {

    private LanguageEnum language;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;


}
