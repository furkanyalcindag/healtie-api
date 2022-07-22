package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.PaymentMoment;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface PaymentMomentRepository extends BaseRepository<PaymentMoment> {

    @Query("SELECT sum(p.paidAmount) FROM PaymentMoment p" +
            " WHERE p.userUUID=?1  AND p.creationDate between ?2 and ?3 ")
    float getTotalPaymentByDate(UUID userUUID, Date startDate, Date endDate); //for user


}
