package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "academic_info_uuid"
        )
)
public class AcademicInfo extends BaseEntity {

    @Column
    private String schoolName;

    @Column
    private String profession;

    @Column
    private Date startYear;

    @Column
    private Date graduateYear;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Doctor doctor;


}
