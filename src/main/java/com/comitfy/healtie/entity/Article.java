package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Article {
    @Id
    private long id;
    private String title;
    private long text;
    private String keyword;
    private String languageCode;

}
