package com.comitfy.healtie.statistics.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class OrderStatisticsDTO extends BaseDTO {

    private Date startDate;
    private Date endDate;
}
