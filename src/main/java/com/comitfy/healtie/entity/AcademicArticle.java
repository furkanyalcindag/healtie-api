package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class AcademicArticle {
    @Id
    private long id;
    private String title;
    private String publishedPlatform;
    private Date publishedDate;

    @ManyToOne
    private Doctor doctor;

}
