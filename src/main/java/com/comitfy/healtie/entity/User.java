package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String firstName;
    @Column
    private String userType;
    @Column
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

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;

    @ManyToMany(mappedBy = "viewUsers",fetch = FetchType.LAZY)
    private Set<Article> views;

    @ManyToMany(mappedBy = "pinUsers",fetch = FetchType.LAZY)
    private Set<Article> pins;
*/
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();



}
