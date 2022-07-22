package com.comitfy.healtie.statistics.service;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.model.enums.OrderStatusEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.PaymentMomentRepository;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.statistics.dto.OrderStatisticsDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public float getTotalAmountOfDate(UUID userUUID, OrderStatisticsDTO dto) {
        return paymentMomentRepository.getTotalPaymentByDate(userUUID, dto.getStartDate(), dto.getEndDate());

    }

    public long getTotalOrderOfDate(UUID userUUID, OrderStatusEnum orderStatusEnum, OrderStatisticsDTO dto) {
        return orderRepository.getTotalOrderByDate(userUUID, orderStatusEnum, dto.getStartDate(), dto.getEndDate());

    }

    public float getTotalPriceOfDate(PaymentStatusEnum paymentStatusEnum, OrderStatisticsDTO dto) {
        return orderRepository.getTotalPriceByDate(paymentStatusEnum, dto.getStartDate(), dto.getEndDate());

    }

    public long getCountOfOrderByDate(PaymentStatusEnum paymentStatusEnum, OrderStatisticsDTO dto) {
        return orderRepository.getCountOfOrderByDate(paymentStatusEnum, dto.getStartDate(), dto.getEndDate());

    }

}
