package com.comitfy.healtie.userModule.model.requestModel.auth;

import com.comitfy.healtie.app.model.enums.AgeRangeEnum;
import com.comitfy.healtie.app.model.enums.GenderEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String confirmPassword;
  //  private UUID genderUUID;

    private AgeRangeEnum ageRangeEnum;
    private GenderEnum genderEnum;


}
