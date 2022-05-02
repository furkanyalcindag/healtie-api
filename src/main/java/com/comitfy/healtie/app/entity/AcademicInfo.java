package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class AcademicInfo extends BaseEntity {

    @Column
    private String schoolName;

    @Column
    private String profession;

    @Column
    private Date startYear;

    @Column
    private Date graduateYear;

    @ManyToOne()
    @JoinColumn
    private Doctor doctor;

}
