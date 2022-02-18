package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
public class Country extends BaseEntity {


    @Column
    private String name;

    @Column
    private String code;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<User> userList;


}
