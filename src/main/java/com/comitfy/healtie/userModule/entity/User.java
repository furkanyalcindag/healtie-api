package com.comitfy.healtie.userModule.entity;


import com.comitfy.healtie.app.entity.Gender;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column
    private boolean isEnable;





    /*@JoinTable(name = "user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> group;*/

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Gender gender;


    @ManyToMany
    private Set<Role> roles;


    public User() {
        isEnable = false;
    }

}
