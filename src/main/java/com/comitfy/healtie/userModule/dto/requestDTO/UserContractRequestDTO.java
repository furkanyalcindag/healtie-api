package com.comitfy.healtie.userModule.dto.requestDTO;

import com.comitfy.healtie.userModule.dto.ContractDTO;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserContractRequestDTO extends BaseDTO {
   // private Set<ContractDTO> contractDTOList;
    private UUID contractUuid;

    private boolean isSigned;
}
