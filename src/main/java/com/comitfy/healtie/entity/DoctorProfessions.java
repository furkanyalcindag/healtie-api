package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DoctorProfessions{
    @Id
    private long id;
    private String profession;
    private long doctorId;

}
