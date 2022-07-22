package com.comitfy.healtie.commercial.entity;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "product_uuid"
        )
)
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column(columnDefinition = "Text", length = 100000)
    private String description;

    @Column
    private String location;

    @Column
    private Float width;

    @Column
    private Float height;

    @Column
    private Float price;

    @Column
    private Float taxRatio;

    @Column
    private Float totalPrice;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private ProductCategory productCategory;




}
