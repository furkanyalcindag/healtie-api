package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.CustomerDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerRequestDTO;
import com.comitfy.healtie.commercial.entity.Customer;
import com.comitfy.healtie.commercial.mapper.CustomerMapper;
import com.comitfy.healtie.commercial.repository.AdvertisementRepository;
import com.comitfy.healtie.commercial.repository.CustomerRepository;
import com.comitfy.healtie.commercial.specification.CustomerSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<CustomerDTO, CustomerRequestDTO, Customer, CustomerRepository, CustomerMapper, CustomerSpecification> {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerSpecification customerSpecification;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Override
    public CustomerRepository getRepository() {
        return customerRepository;
    }

    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public CustomerSpecification getSpecification() {
        return customerSpecification;
    }

    public CustomerRequestDTO saveCustomerByUser(UUID id, CustomerRequestDTO dto) {
        Optional<User> user = userRepository.findByUuid(id);
        if (user.isPresent()) {
            Customer customer = getMapper().requestDTOToEntity(dto);
            customerRepository.save(customer);

            return dto;
        } else {
            return null;
        }

    }


    public CustomerRequestDTO updateCustomer(UUID id, CustomerRequestDTO dto, User user) {
        Optional<Customer> customer = customerRepository.findByUuid(id);
        if (customer.isPresent()) {
            Customer customer1 = customerMapper.requestDTOToExistEntity(customer.get(), dto);
            customerRepository.save(customer1);
            return dto;
        } else {
            return null;
        }

    }
}
