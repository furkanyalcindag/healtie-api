package com.comitfy.healtie.commercial.repository;

import com.comitfy.healtie.commercial.entity.PaymentMoment;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Repository
public interface PaymentMomentRepository extends BaseRepository<PaymentMoment> {

/*    @Query("SELECT useruuid, date_part('year',order_date) as order_year," + ?
            "sum(paid_amount) as amount_total from payment_moment group by useruuid,date_part('year',order_date)")
    long sumOfPaymentAsYear(UUID userId, LocalDateTime start, LocalDateTime end);*/

    @Query("SELECT sum(p.paidAmount) FROM PaymentMoment p" +
            " WHERE p.userUUID=?1 AND p.paymentStatusEnum=?2 AND p.creationDate between ?3 and ?4 ")
    float getTotalPaymentByDate(UUID userUUID, PaymentStatusEnum paymentStatus, Date startDate, Date endDate);


    /*    @Query("SELECT COUNT(saves) FROM Article article " +
            "inner join article.userSaves saves  WHERE article.uuid=?1 and saves.uuid=?2")
    long isSavedByUser(UUID articleUUID, UUID userUUID);

    @Query("SELECT COUNT(article) FROM Article article" +
            " inner join article.categoryList category WHERE category.uuid=?1")
    long getCountOfArticleByCategory(UUID categoryUUID);*/

}
