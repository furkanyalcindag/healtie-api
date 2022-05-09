package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class CertificateRequestDTO extends BaseDTO {

    private String name;
    private String certificateNo;
    private String takenFrom;
    private Date takenDate;

}
