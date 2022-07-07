package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.commercial.dto.CustomerDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerRequestDTO;
import com.comitfy.healtie.commercial.entity.Customer;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements BaseMapper<CustomerDTO, CustomerRequestDTO, Customer> {
    @Override
    public CustomerDTO entityToDTO(Customer entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setTelNo(entity.getTelNo());
        customerDTO.setAddress(entity.getAddress());
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setUuid(entity.getUuid());
        return customerDTO;
    }

    @Override
    public Customer dtoToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCompanyName(dto.getCompanyName());
        customer.setTelNo(dto.getTelNo());
        customer.setAddress(dto.getAddress());
        customer.setTaxNumber(dto.getTaxNumber());
        return customer;
    }

    @Override
    public Customer requestDTOToEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setCompanyName(dto.getCompanyName());
        customer.setTelNo(dto.getTelNo());
        customer.setAddress(dto.getAddress());
        customer.setTaxNumber(dto.getTaxNumber());
        return customer;
    }

    @Override
    public Customer requestDTOToExistEntity(Customer customer, CustomerRequestDTO dto) {

        customer.setCompanyName(dto.getCompanyName());
        customer.setTelNo(dto.getTelNo());
        customer.setAddress(dto.getAddress());
        customer.setTaxNumber(dto.getTaxNumber());
        return customer;
    }

    @Override
    public List<Customer> dtoListToEntityList(List<CustomerDTO> customerDTOS) {
        List<Customer> customerList = new ArrayList<Customer>();
        for (CustomerDTO customerDTO : customerDTOS) {
            Customer customer = dtoToEntity(customerDTO);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = entityToDTO(customer);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public PageDTO<CustomerDTO> pageEntityToPageDTO(Page<Customer> pageEntity) {
        PageDTO<CustomerDTO> pageDTO = new PageDTO<CustomerDTO>();
        List<Customer> customerList = pageEntity.toList();
        List<CustomerDTO> customerDTOList = entityListToDTOList(customerList);
        pageDTO.setStart(pageEntity, customerDTOList);

        return pageDTO;
    }
}
