package com.comitfy.healtie.commercial.dto;

import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class AdvertisementDTO extends BaseDTO {
    private String location;
    private float width;
    private float height;
    private float price;
    private float totalPrice;
}
