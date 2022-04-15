package com.comitfy.healtie.userModule.entity;


import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "crm_group")
public class Group extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;


}
