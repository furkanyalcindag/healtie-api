package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Article {
    @Id
    private long id;
    private String title;
    private long text;
    private String keyword;
    private String languageCode;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "view_user",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> viewUsers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pin_user",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> pinUsers;


}
