package com.comitfy.healtie.userModule.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class UserContractDTO extends BaseDTO {
  //  private UUID userUuid;
    private UUID contractUuid;
    private boolean isSigned;
    private boolean isActive;
    private boolean isRequire;
   // private Set<ContractDTO> contractDTOS;
}
