package com.comitfy.healtie.commercial.entity;

import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
public class Customer extends BaseEntity {

    @Column
    private String companyName;

    @Column
    private String telNo;

    @Column
    private String address;

    @Column
    private String taxNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToMany
    private Set<Role> roles;

}
