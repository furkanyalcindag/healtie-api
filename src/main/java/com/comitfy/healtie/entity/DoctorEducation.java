package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table
public class DoctorEducation extends BaseEntity {

    private String academyName;
    private String finishedYear;

    //@ManyToOne
    //private Doctor doctor;


}
