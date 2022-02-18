package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table
public class DoctorProfessions extends BaseEntity{

    private String profession;
    private long doctorId;

}
