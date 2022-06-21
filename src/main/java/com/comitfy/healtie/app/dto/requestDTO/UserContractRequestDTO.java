package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.dto.ContractDTO;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserContractRequestDTO extends BaseDTO {
    private Set<ContractDTO> contractDTOS;
    private UUID contractUuid;

    private boolean isSigned;
}
