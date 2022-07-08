package com.comitfy.healtie.commercial.dto;

import com.comitfy.healtie.commercial.model.enums.CheckingTypeEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDTO extends BaseDTO {

    private UUID userUUID;
    private UUID productUUID;
    private LocalDate orderDate;

    private LocalDate deliveryDate;;

    private Float netPrice;

    private Float totalPrice;

    private Float taxRatio;

    private Float paidAmount;

    private CheckingTypeEnum checkingTypeEnum;

    private PaymentStatusEnum paymentStatusEnum;
}
