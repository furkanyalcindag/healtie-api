package com.comitfy.healtie.commercial.dto.request;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerAdvertisementOrderRequestDTO extends BaseDTO {

    private UUID customerUUID;
    private UUID advertisementUUID;
    private float price;
}
