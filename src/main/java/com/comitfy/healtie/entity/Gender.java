package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
public class Gender extends BaseEntity {


    @Column
    private String keyword;

    @OneToMany(mappedBy = "gender")
    private Set<User> userList;

}
