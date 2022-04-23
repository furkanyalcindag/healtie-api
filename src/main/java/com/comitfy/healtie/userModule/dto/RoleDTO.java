package com.comitfy.healtie.userModule.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class RoleDTO extends BaseDTO {


    private String name;
    private UUID uuid;


}
