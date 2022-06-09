package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "experience_uuid"
        )
)
public class Experience extends BaseEntity {

    @Column
    private String title;

    @Column
    private String workedPlace;

    @Column
    private String description;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Doctor doctor;
}
