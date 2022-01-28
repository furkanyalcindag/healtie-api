package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class DoctorEducation extends BaseEntity{

    private String academyName;
    private String finishedYear;
    private long doctorId;



}
