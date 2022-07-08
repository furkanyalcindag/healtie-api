package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Orders;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements BaseMapper<OrderDTO, OrderRequestDTO, Orders> {

    @Override
    public OrderDTO entityToDTO(Orders entity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserUUID(entity.getUserUUID());
        orderDTO.setProductUUID(entity.getProductUUID());
        orderDTO.setOrderDate(entity.getOrderDate());
        orderDTO.setDeliveryDate(entity.getDeliveryDate());

        orderDTO.setUuid(entity.getUuid());
        return orderDTO;
    }

    @Override
    public Orders dtoToEntity(OrderDTO dto) {
        Orders orders = new Orders();
        orders.setUserUUID(dto.getUserUUID());
        orders.setProductUUID(dto.getProductUUID());
        orders.setOrderDate(dto.getOrderDate());
        orders.setDeliveryDate(dto.getDeliveryDate());
        orders.setNetPrice(dto.getNetPrice());
        orders.setPaidAmount(dto.getPaidAmount());
        orders.setTaxRatio(orders.getTaxRatio());
        orders.setTotalPrice(dto.getTotalPrice());
        orders.setCheckingTypeEnum(dto.getCheckingTypeEnum());
        orders.setPaymentStatusEnum(dto.getPaymentStatusEnum());
        return orders;
    }

    @Override
    public Orders requestDTOToEntity(OrderRequestDTO dto) {
        Orders orders = new Orders();
        orders.setUserUUID(dto.getUserUUID());
        orders.setProductUUID(dto.getProductUUID());
        orders.setNetPrice(dto.getNetPrice());
        orders.setPaidAmount(dto.getPaidAmount());
        orders.setTaxRatio(orders.getTaxRatio());
        orders.setTotalPrice(dto.getTotalPrice());

        return orders;
    }

    @Override
    public Orders requestDTOToExistEntity(Orders orders, OrderRequestDTO dto) {

        orders.setUserUUID(dto.getUserUUID());
        orders.setProductUUID(dto.getProductUUID());
        orders.setNetPrice(dto.getNetPrice());
        orders.setPaidAmount(dto.getPaidAmount());
        orders.setTaxRatio(orders.getTaxRatio());
        orders.setTotalPrice(dto.getTotalPrice());
        return orders;
    }

    @Override
    public List<Orders> dtoListToEntityList(List<OrderDTO> orderDTOS) {
        List<Orders> ordersList = new ArrayList<Orders>();
        for (OrderDTO orderDTO : orderDTOS) {
            Orders orders = dtoToEntity(orderDTO);
            ordersList.add(orders);
        }
        return ordersList;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<Orders> orders) {
        List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
        for (Orders order : orders) {
            OrderDTO orderDTO = entityToDTO(order);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }


    @Override
    public PageDTO<OrderDTO> pageEntityToPageDTO(Page<Orders> pageEntity) {
        PageDTO<OrderDTO> pageDTO = new PageDTO<OrderDTO>();
        List<Orders> entityList = pageEntity.toList();
        List<OrderDTO> orderDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, orderDTOList);

        return pageDTO;
    }
}

