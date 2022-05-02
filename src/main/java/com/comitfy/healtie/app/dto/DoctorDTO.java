package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class DoctorDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private String title;
    private String diplomaNo;
    private String email;
    private String address;
    private String phone;


}
