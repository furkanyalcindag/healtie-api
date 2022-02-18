package com.comitfy.healtie.entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table
@Data
public class Nationality extends BaseEntity {


    private String name;

//    @ManyToMany(mappedBy = "nationalities")
//    private List<User> userList;



}
