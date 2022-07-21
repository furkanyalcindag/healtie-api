package com.comitfy.healtie.statistics.service;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.OrderStatisticsDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.PaymentMomentRepository;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderStatisticsService extends BaseService<OrderDTO, OrderRequestDTO, Order, OrderRepository, OrderMapper, OrderSpecification> {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderSpecification orderSpecification;

    @Autowired
    PaymentMomentRepository paymentMomentRepository;

    @Override
    public OrderRepository getRepository() {
        return orderRepository;
    }

    @Override
    public OrderMapper getMapper() {
        return orderMapper;
    }

    @Override
    public OrderSpecification getSpecification() {
        return orderSpecification;
    }


    public float getTotalAmountOfYear(UUID userUUID, PaymentStatusEnum paymentStatus, OrderStatisticsDTO dto) {
        return paymentMomentRepository.getTotalPaymentByDate(userUUID, paymentStatus, dto.getStartDate(),dto.getEndDate());

    }

}
