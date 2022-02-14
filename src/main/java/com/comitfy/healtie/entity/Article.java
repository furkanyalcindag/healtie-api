package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
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

    @ManyToMany
    @JoinTable(
            name = "view_user",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> viewUsers;

    @ManyToMany
    @JoinTable(
            name = "pin_user",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> pinUsers;


}
