package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String title;
    private String diplomaNo;
    private String address;
    private String phone;
    private String clinicName;

    @JsonIgnore
    private LanguageEnum languageEnum;


    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
