package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table
@Data
public class Doctor extends BaseEntity {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String title;

    @Column(unique = true)
    private String diplomaNo;

    @Email
    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String phone;

    @OneToMany(mappedBy = "doctor")
    private List<AcademicInfo> academicInfoList;


}
