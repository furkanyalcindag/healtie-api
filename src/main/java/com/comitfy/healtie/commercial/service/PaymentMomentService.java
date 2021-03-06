package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.PaymentMomentDTO;
import com.comitfy.healtie.commercial.dto.request.PaymentMomentRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.entity.PaymentMoment;
import com.comitfy.healtie.commercial.mapper.PaymentMomentMapper;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.PaymentMomentRepository;
import com.comitfy.healtie.commercial.specification.PaymentMomentSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service

public class PaymentMomentService extends BaseService<PaymentMomentDTO, PaymentMomentRequestDTO, PaymentMoment, PaymentMomentRepository, PaymentMomentMapper, PaymentMomentSpecification> {

    Logger log = LoggerFactory.getLogger(PaymentMomentService.class);
    @Autowired
    PaymentMomentRepository paymentMomentRepository;

    @Autowired
    PaymentMomentMapper paymentMomentMapper;

    @Autowired
    PaymentMomentSpecification paymentMomentSpecification;

    @Autowired
    OrderRepository orderRepository;


    @Override
    public PaymentMomentRepository getRepository() {
        return paymentMomentRepository;
    }

    @Override
    public PaymentMomentMapper getMapper() {
        return paymentMomentMapper;
    }

    @Override
    public PaymentMomentSpecification getSpecification() {
        return paymentMomentSpecification;
    }

    public PaymentMomentRequestDTO saveOrderPayment(UUID orderId, PaymentMomentRequestDTO dto, User user) {

        Optional<Order> orders = orderRepository.findByUuid(orderId);
        if (orders.isPresent()) {

            PaymentMoment paymentMoment = getMapper().requestDTOToEntity(dto);
            paymentMoment.setOrderUUID(orderId);
            paymentMoment.setUserUUID(user.getUuid());
            paymentMoment.setCheckingTypeEnum(orders.get().getCheckingTypeEnum());
           // paymentMoment.setOrderDate(orders.get().getOrderDate());

            if (dto.getPaidAmount() > orders.get().getRemainingMoney()) {
                return null;
            } else {
                paymentMoment.setPaidAmount(dto.getPaidAmount());
            }

            orders.get().setRemainingMoney(orders.get().getRemainingMoney() - paymentMoment.getPaidAmount());

 /*           if (orders.get().getRemainingMoney() <= 0) {
                paymentMoment.setPaymentStatusEnum(PaymentStatusEnum.PAID);
                orders.get().setPaymentStatusEnum(PaymentStatusEnum.PAID);
            } else if (orders.get().getRemainingMoney() < orders.get().getTotalPrice()) {
                paymentMoment.setPaymentStatusEnum(PaymentStatusEnum.PARTIALLY_PAID);
                orders.get().setPaymentStatusEnum(PaymentStatusEnum.PARTIALLY_PAID);
            } else {
                paymentMoment.setPaymentStatusEnum(PaymentStatusEnum.UNPAID);
                orders.get().setPaymentStatusEnum(PaymentStatusEnum.UNPAID);
            }
*/
            paymentMomentRepository.save(paymentMoment);
            return dto;

        } else {
            log.info("OrderId is null.");
          return null;
        }
    }

}
