package com.comitfy.healtie.userModule.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class UserRequestDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private String email;
}
