package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {

    private String title;
    private String diplomaNo;
    private String address;
    private String phone;
    private String clinicName;


}
