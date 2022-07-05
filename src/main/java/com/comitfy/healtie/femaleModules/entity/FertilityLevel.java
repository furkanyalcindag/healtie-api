package com.comitfy.healtie.femaleModules.entity;

import com.comitfy.healtie.femaleModules.model.enums.FertilityLevelEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "fertility_level_uuid"))
public class FertilityLevel extends BaseEntity {

    @Column
    private LocalDate date;
    @Column
    private FertilityLevelEnum fertilityLevelEnum;
}
