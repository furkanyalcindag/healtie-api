package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
@Data
public class Category extends BaseEntity {

    @OneToMany(mappedBy="category", fetch = FetchType.EAGER)
    private Set<CategoryTranslation> translations;
}
