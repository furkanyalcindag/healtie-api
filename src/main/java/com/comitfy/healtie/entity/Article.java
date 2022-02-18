package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
public class Article extends BaseEntity {

    private String title;
    private long text;
    private String keyword;
    private String languageCode;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "view_users",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> viewUsers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pin_users",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> pinUsers;


}
