package com.comitfy.healtie.commercial.dto;

import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.util.common.BaseDTO;
import lombok.Data;

@Data
public class ProductDTO extends BaseDTO {
    private String location;
    private float width;
    private float height;
    private float price;
    private float totalPrice;
    private String description;
    private String name;

}
