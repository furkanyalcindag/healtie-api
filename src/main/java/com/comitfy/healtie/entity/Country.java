package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;


    @OneToMany(mappedBy = "country")
    private Set<User> userList;


}
