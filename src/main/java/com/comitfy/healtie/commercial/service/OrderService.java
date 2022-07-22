package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.dto.request.OrderStatusRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.model.enums.CardStatusEnum;
import com.comitfy.healtie.commercial.model.enums.CheckingTypeEnum;
import com.comitfy.healtie.commercial.model.enums.OrderStatusEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.ProductRepository;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderDTO, OrderRequestDTO, Order, OrderRepository, OrderMapper, OrderSpecification> {

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
            Order order = getMapper().requestDTOToEntity(dto);
            order.setProductUUID(productId);
            order.setUserUUID(user.getUuid());
            order.setNetPrice(product.get().getPrice());
            order.setTaxRatio(product.get().getTaxRatio());
            order.setTotalPrice(product.get().getPrice() + (product.get().getPrice() * product.get().getTaxRatio()) / 100);
            order.setCheckingTypeEnum(CheckingTypeEnum.INCOME);
            order.setOrderStatusEnum(OrderStatusEnum.ON_HOLD);
            order.setCardStatusEnum(CardStatusEnum.APPROVED);
            order.setRemainingMoney(order.getTotalPrice());
            order.setOrderDate(LocalDate.from(LocalDateTime.now()));


            if (order.getRemainingMoney() == 0) {
                order.setPaymentStatusEnum(PaymentStatusEnum.PAID);
            } else if (order.getRemainingMoney() < order.getTotalPrice()) {
                order.setPaymentStatusEnum(PaymentStatusEnum.PARTIALLY_PAID);
            } else {
                order.setPaymentStatusEnum(PaymentStatusEnum.UNPAID);
            }

            orderRepository.save(order);

            return dto;

        } else return null;
    }

    public OrderStatusRequestDTO updateOrderStatusEnum(OrderStatusRequestDTO dto, UUID id) {
        Optional<Order> order = orderRepository.findByUuid(id);
        if (order.isPresent()) {
            Order order1 = orderMapper.requestDTOToExistEntityForOrderStatusEnum(order.get(), dto);
            order1.setOrderStatusEnum(dto.getOrderStatusEnum());
            orderRepository.save(order1);
            return dto;
        } else {
            return null;
        }

    }

    public PageDTO<OrderDTO> getOrderByUser(int page,int size,User user){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("orderDate")));

      return getMapper().pageEntityToPageDTO(orderRepository.findAll(pageable));

    }


}



