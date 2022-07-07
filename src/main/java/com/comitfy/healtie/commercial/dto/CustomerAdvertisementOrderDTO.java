package com.comitfy.healtie.commercial.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerAdvertisementOrderDTO extends BaseDTO {

    private UUID customerUUID;
    private UUID advertisementUUID;
    private float price;
}
