package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    @Query("SELECT sum(p.paidAmount) FROM PaymentMoment p")
    long getSumOfPaymentAmount(UUID uuid);



}
