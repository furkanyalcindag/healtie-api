package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.commercial.dto.CustomerAdvertisementOrderDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerAdvertisementOrderRequestDTO;
import com.comitfy.healtie.commercial.entity.CustomerAdvertisementOrder;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerAdvertisementOrderMapper implements BaseMapper<CustomerAdvertisementOrderDTO, CustomerAdvertisementOrderRequestDTO, CustomerAdvertisementOrder> {

    @Override
    public CustomerAdvertisementOrderDTO entityToDTO(CustomerAdvertisementOrder entity) {
        CustomerAdvertisementOrderDTO customerAdvertisementOrderDTO = new CustomerAdvertisementOrderDTO();
        customerAdvertisementOrderDTO.setCustomerUUID(entity.getCustomerUUID());
        customerAdvertisementOrderDTO.setAdvertisementUUID(entity.getAdvertisementUUID());
        customerAdvertisementOrderDTO.setPrice(entity.getPrice());
        customerAdvertisementOrderDTO.setUuid(entity.getUuid());
        return customerAdvertisementOrderDTO;
    }

    @Override
    public CustomerAdvertisementOrder dtoToEntity(CustomerAdvertisementOrderDTO dto) {
        CustomerAdvertisementOrder customerAdvertisementOrder = new CustomerAdvertisementOrder();
        customerAdvertisementOrder.setCustomerUUID(dto.getCustomerUUID());
        customerAdvertisementOrder.setAdvertisementUUID(dto.getAdvertisementUUID());
        customerAdvertisementOrder.setPrice(dto.getPrice());
        return customerAdvertisementOrder;
    }

    @Override
    public CustomerAdvertisementOrder requestDTOToEntity(CustomerAdvertisementOrderRequestDTO dto) {
        CustomerAdvertisementOrder customerAdvertisementOrder = new CustomerAdvertisementOrder();
        customerAdvertisementOrder.setCustomerUUID(dto.getCustomerUUID());
        customerAdvertisementOrder.setAdvertisementUUID(dto.getAdvertisementUUID());
        customerAdvertisementOrder.setPrice(dto.getPrice());
        return customerAdvertisementOrder;
    }

    @Override
    public CustomerAdvertisementOrder requestDTOToExistEntity(CustomerAdvertisementOrder customerAdvertisementOrder, CustomerAdvertisementOrderRequestDTO dto) {

        customerAdvertisementOrder.setCustomerUUID(dto.getCustomerUUID());
        customerAdvertisementOrder.setAdvertisementUUID(dto.getAdvertisementUUID());
        customerAdvertisementOrder.setPrice(dto.getPrice());
        return customerAdvertisementOrder;
    }

    @Override
    public List<CustomerAdvertisementOrder> dtoListToEntityList(List<CustomerAdvertisementOrderDTO> customerAdvertisementOrderDTOS) {
        List<CustomerAdvertisementOrder> customerAdvertisementOrderList = new ArrayList<CustomerAdvertisementOrder>();
        for (CustomerAdvertisementOrderDTO customerAdvertisementOrderDTO : customerAdvertisementOrderDTOS) {
            CustomerAdvertisementOrder customerAdvertisementOrder = dtoToEntity(customerAdvertisementOrderDTO);
            customerAdvertisementOrderList.add(customerAdvertisementOrder);
        }
        return customerAdvertisementOrderList;
    }

    @Override
    public List<CustomerAdvertisementOrderDTO> entityListToDTOList(List<CustomerAdvertisementOrder> customerAdvertisementOrders) {
        List<CustomerAdvertisementOrderDTO> customerAdvertisementOrderDTOList = new ArrayList<CustomerAdvertisementOrderDTO>();
        for (CustomerAdvertisementOrder customerAdvertisementOrder : customerAdvertisementOrders) {
            CustomerAdvertisementOrderDTO customerAdvertisementOrderDTO = entityToDTO(customerAdvertisementOrder);
            customerAdvertisementOrderDTOList.add(customerAdvertisementOrderDTO);
        }
        return customerAdvertisementOrderDTOList;
    }


    @Override
    public PageDTO<CustomerAdvertisementOrderDTO> pageEntityToPageDTO(Page<CustomerAdvertisementOrder> pageEntity) {
        PageDTO<CustomerAdvertisementOrderDTO> pageDTO = new PageDTO<CustomerAdvertisementOrderDTO>();
        List<CustomerAdvertisementOrder> entityList = pageEntity.toList();
        List<CustomerAdvertisementOrderDTO> customerAdvertisementOrderDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, customerAdvertisementOrderDTOList);

        return pageDTO;
    }
}

