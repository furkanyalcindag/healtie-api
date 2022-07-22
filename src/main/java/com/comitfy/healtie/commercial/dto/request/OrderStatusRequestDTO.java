package com.comitfy.healtie.commercial.dto.request;

import com.comitfy.healtie.commercial.model.enums.OrderStatusEnum;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class OrderStatusRequestDTO extends BaseDTO {
    private OrderStatusEnum orderStatusEnum;
}
