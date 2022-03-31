package com.comitfy.healtie.user.entity;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "crm_group")
public class CrmGroup extends BaseEntity {
    @Column
    private String groupId;
    @Column
    private String userId;



}
