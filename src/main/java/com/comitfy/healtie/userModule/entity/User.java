package com.comitfy.healtie.userModule.entity;


import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "user")
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

    @JoinTable(name = "user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> group;

    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "role_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Role> roles;

    public User() {
        isEnable = false;
    }

}
