package com.comitfy.healtie.userModule.entity;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "crm_role")
public class CrmRole extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;

    public CrmRole() {

    }



}
