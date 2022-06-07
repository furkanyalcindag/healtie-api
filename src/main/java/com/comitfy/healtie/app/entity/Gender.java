package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "gender_uuid"
        )
)
public class Gender extends BaseEntity {

    @Column
    private String gender;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctorList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

}
