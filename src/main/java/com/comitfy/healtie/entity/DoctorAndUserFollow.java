package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class DoctorAndUserFollow extends BaseEntity{
    private long userId;
    private long doctorId;
}
