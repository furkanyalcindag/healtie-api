package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DoctorAcademicArticles {
    @Id
    private long id;
    private String title;
    private String publishedPlatform;
    private Date publishedDate;
    private long doctorId;

}
