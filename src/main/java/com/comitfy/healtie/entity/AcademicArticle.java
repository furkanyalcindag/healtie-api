package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class AcademicArticle extends BaseEntity {

    private String title;
    private String publishedPlatform;
    private Date publishedDate;

    @ManyToOne
    private Doctor doctor;

}
