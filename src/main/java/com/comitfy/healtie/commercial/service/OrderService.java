package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Orders;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.model.enums.CheckingTypeEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.ProductRepository;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderDTO, OrderRequestDTO, Orders, OrderRepository, OrderMapper, OrderSpecification> {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderSpecification orderSpecification;

    @Autowired
    ProductRepository productRepository;

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

    public OrderRequestDTO saveOrderByProduct(UUID productId, OrderRequestDTO dto, User user) {

        Optional<Product> product = productRepository.findByUuid(productId);
        if (product.isPresent()) {
            Orders orders = getMapper().requestDTOToEntity(dto);
            orders.setProductUUID(productId);
            orders.setUserUUID(user.getUuid());
            orders.setNetPrice(product.get().getPrice());
            orders.setTaxRatio(product.get().getTaxRatio());
            orders.setTotalPrice(product.get().getPrice() + (product.get().getPrice() * product.get().getTaxRatio()) / 100);
            orders.setPaymentStatusEnum(PaymentStatusEnum.UNPAID);
            orders.setCheckingTypeEnum(CheckingTypeEnum.INCOME);
            orders.setRemainingMoney(orders.getTotalPrice());


            orderRepository.save(orders);

            return dto;

        } else return null;
    }

    public OrderRequestDTO saveOrderPayment(UUID orderId, OrderRequestDTO dto, User user) {
        Optional<Orders> orders = orderRepository.findByUuid(orderId);
        if (orderId != null) {

            Orders orders1 = getMapper().requestDTOToEntity(dto);
            orders1.setProductUUID(orders.get().getProductUUID());
            orders1.setUserUUID(user.getUuid());
            orders1.setNetPrice(orders.get().getNetPrice());
            orders1.setTaxRatio(orders.get().getTaxRatio());
            orders1.setPaidAmount(dto.getPaidAmount());
            orders1.setTotalPrice(orders.get().getTotalPrice());

            orders1.setRemainingMoney(orders.get().getRemainingMoney() - orders1.getPaidAmount());

            if (orders1.getRemainingMoney() == 0) {
                orders1.setPaymentStatusEnum(PaymentStatusEnum.PAID);
            } else if (orders1.getRemainingMoney() < orders.get().getTotalPrice()) {
                orders1.setPaymentStatusEnum(PaymentStatusEnum.PARTIALLY_PAID);
            } else {
                orders1.setPaymentStatusEnum(PaymentStatusEnum.UNPAID);
            }

            orderRepository.save(orders1);
            return dto;
        } else {
            return null;
        }
    }
}



