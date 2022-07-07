package com.comitfy.healtie.femaleModules.entity;

import com.comitfy.healtie.app.entity.Tag;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
    private LocalDate startingDate;

    @Column
    private LocalDate estimatedDate;

    @Column
    private boolean activated;

    @Column
    private boolean actuality;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private User user;


}
