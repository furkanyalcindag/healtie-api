package com.comitfy.healtie.userModule.model.requestModel.auth;

import com.comitfy.healtie.app.model.enums.AgeRangeEnum;
import com.comitfy.healtie.app.model.enums.GenderEnum;
import com.comitfy.healtie.userModule.dto.ContractDTO;
import com.comitfy.healtie.userModule.dto.UserContractDTO;
import lombok.Data;

import java.util.List;

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

    List<UserContractDTO> contractDTOList;


}
