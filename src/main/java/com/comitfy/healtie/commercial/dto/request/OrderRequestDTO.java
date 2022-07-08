package com.comitfy.healtie.commercial.dto.request;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderRequestDTO extends BaseDTO {

    private UUID userUUID;
    private UUID productUUID;

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private Float netPrice;

    private Float totalPrice;

    private Float taxRatio;

    private Float paidAmount;


}
