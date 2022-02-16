package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class DoctorEducation extends BaseEntity {

    private String academyName;
    private String finishedYear;

    @ManyToOne
    private Doctor doctor;


}
