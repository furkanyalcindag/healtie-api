package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Gender {
    @Id
    private Long id;

    @Column
    private String keyword;

    @OneToMany(mappedBy = "gender")
    private Set<User> userList;

}
