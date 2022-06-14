package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class DoctorProfileClickRequestDTO extends BaseDTO {
    private UUID doctorUUID;
    private UUID userUUID;
}
