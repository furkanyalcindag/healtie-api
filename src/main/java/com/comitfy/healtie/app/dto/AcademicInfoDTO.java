package com.comitfy.healtie.app.dto;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AcademicInfoDTO extends BaseDTO {

    private String schoolName;
    private String profession;
    private LocalDate startYear;
    private LocalDate graduateYear;

}
