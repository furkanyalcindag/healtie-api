package com.comitfy.healtie.commercial.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "product_category_uuid"
        )
)
public class ProductCategory extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList;
}
