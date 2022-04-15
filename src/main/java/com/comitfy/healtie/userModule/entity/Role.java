package com.comitfy.healtie.userModule.entity;


import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "crm_role")
public class Role extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;

    public Role() {

    }



}
