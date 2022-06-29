package com.comitfy.healtie.femaleModules.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "ovulation_cycle_uuid"
        )
)
public class OvulationCycle extends BaseEntity {

    @Column
    private Date startingDate;

    @Column
    private boolean activated;

    @Column
    private boolean actuality;
}
