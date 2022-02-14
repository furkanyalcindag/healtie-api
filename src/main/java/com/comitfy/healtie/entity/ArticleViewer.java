package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ArticleViewer extends BaseEntity {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Article article;

    private String viewedBy;//article a nereden geldi
}
