package com.comitfy.healtie.commercial.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "customer_advertisement_order_uuid"))
public class CustomerAdvertisementOrder extends BaseEntity {


    @Column
    @Type(type = "uuid-char")
    private UUID customerUUID;


    @Column
    @Type(type = "uuid-char")
    private UUID advertisementUUID;

    @Column
    private float price;
}
