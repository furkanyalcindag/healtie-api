package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table
@Data
public class Doctor extends BaseEntity {

    @Column
    private String title;

    @Column(unique = true)
    private String diplomaNo;

    @OneToOne
    private User user;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String clinicName;



    @OneToMany(mappedBy = "doctor")
    private List<AcademicInfo> academicInfoList;


}
