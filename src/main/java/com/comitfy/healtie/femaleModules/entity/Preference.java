package com.comitfy.healtie.femaleModules.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "preference_uuid"
        )
)
public class Preference extends BaseEntity {
    @Column
    private int expectedNumberOfDay;
}
