package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Doctor extends BaseEntity {

    @Column
    private String title;

    @Column(unique = true)
    private String diplomaNo;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String clinicName;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AcademicInfo> academicInfoList;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Certificate> certificateList;

/*    public void addAcademicInfo(AcademicInfo academicInfo) {
        academicInfoList.add(academicInfo);
        academicInfo.setDoctor(this);
    }*/

}



