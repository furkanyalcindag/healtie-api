package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.model.enums.OrderStatusEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<Order> {


    @Query("SELECT COUNT(o.id) FROM Order o" +
            " WHERE o.userUUID=?1 AND o.orderStatusEnum=?2 AND o.creationDate between ?3 and ?4   ")
    long getTotalOrderByDate(UUID userUUID, OrderStatusEnum orderStatusEnum, Date startDate, Date endDate);

    @Query("SELECT Sum(o.totalPrice) FROM Order o" +
            " WHERE o.paymentStatusEnum=?1 AND o.creationDate between ?2 and ?3")
    float getTotalPriceByDate(PaymentStatusEnum paymentStatusEnum, Date startDate, Date endDate); //for admin

    @Query("SELECT COUNT(o.id) FROM Order o" +
            " WHERE o.paymentStatusEnum=?1 AND o.creationDate between ?2 and ?3   ")
    long getCountOfOrderByDate(PaymentStatusEnum paymentStatusEnum, Date startDate, Date endDate);




}
