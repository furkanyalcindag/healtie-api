package com.comitfy.healtie.userModule.dto;

import com.comitfy.healtie.app.model.enums.AgeRangeEnum;
import com.comitfy.healtie.app.model.enums.GenderEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String photoLink;
    private long likedCount;
    private long savedCount;

    private AgeRangeEnum ageRangeEnum;
    private GenderEnum genderEnum;
}
