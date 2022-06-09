package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CertificateDTO extends BaseDTO {

    private String name;
    private String certificateNo;
    private String takenFrom;
    private LocalDate takenDate;

}
