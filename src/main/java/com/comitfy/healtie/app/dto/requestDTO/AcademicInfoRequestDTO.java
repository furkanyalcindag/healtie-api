package com.comitfy.healtie.app.dto.requestDTO;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AcademicInfoRequestDTO extends BaseDTO {

    private String schoolName;
    private String profession;
    private Date startYear;
    private Date graduateYear;



}
