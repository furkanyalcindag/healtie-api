package com.comitfy.healtie.commercial.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class CustomerDTO extends BaseDTO {


    private String companyName;


    private String telNo;


    private String address;


    private String taxNumber;
}
