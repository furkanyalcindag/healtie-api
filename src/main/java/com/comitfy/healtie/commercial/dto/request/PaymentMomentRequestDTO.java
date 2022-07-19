package com.comitfy.healtie.commercial.dto.request;

import com.comitfy.healtie.commercial.model.enums.CheckingTypeEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentTypeEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
public class PaymentMomentRequestDTO extends BaseDTO {

    private UUID userUUID;
    private UUID orderUUID;

    private PaymentTypeEnum paymentTypeEnum;
    private Date orderDate;

    private LocalDate deliveryDate;

    //private Float totalPrice;


    private Float paidAmount;
   // private Float remainingMoney;
    private CheckingTypeEnum checkingTypeEnum;

    private PaymentStatusEnum paymentStatusEnum;
}
