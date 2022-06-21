package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserContractDTO extends BaseDTO {
    private UUID userUuid;
    private UUID contractUuid;
    private boolean isSigned;
    private Set<ContractDTO> contractDTOS;
}
