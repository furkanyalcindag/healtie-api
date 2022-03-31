package com.comitfy.healtie.user.entity;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "crm_user")
public class CrmUser extends BaseEntity {
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

    @JoinTable(name = "crm_user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<CrmGroup> group;

    public CrmUser() {
        isEnable = false;
    }

}
