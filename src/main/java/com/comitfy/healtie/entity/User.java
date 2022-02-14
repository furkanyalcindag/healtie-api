package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String userType;
    @Column(nullable = false)
    private String phone;
    @Column
    private String birthDate;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String address;
    @Column
    private boolean isEnable;

    public User() {
        isEnable = false;
    }

    @ManyToOne
    private Country country;

    @ManyToOne
    private Gender gender;

    @ManyToMany(mappedBy = "viewUsers")
    private Set<Article> views;

    @ManyToMany(mappedBy = "pinUsers")
    private Set<Article> pins;



}
