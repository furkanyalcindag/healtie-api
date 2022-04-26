package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Category extends BaseEntity {

    @Column
    private String name;


    @Column
    private LanguageEnum languageEnum;

    @ManyToMany
    private Set<Category> parent;

    private boolean isTop;

}
