package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.CustomerDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerRequestDTO;
import com.comitfy.healtie.commercial.entity.Customer;
import com.comitfy.healtie.commercial.mapper.CustomerMapper;
import com.comitfy.healtie.commercial.repository.CustomerRepository;
import com.comitfy.healtie.commercial.service.AdvertisementService;
import com.comitfy.healtie.commercial.service.CustomerService;
import com.comitfy.healtie.commercial.specification.CustomerSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseCrudController<CustomerDTO, CustomerRequestDTO, Customer, CustomerRepository, CustomerMapper, CustomerSpecification, CustomerService> {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    HelperService helperService;

    @Autowired
    AdvertisementService advertisementService;


    @Override
    protected CustomerService getService() {
        return customerService;
    }

    @Override
    protected CustomerMapper getMapper() {
        return customerMapper;
    }

    @PostMapping("/user-api")
    public ResponseEntity<CustomerRequestDTO> saveByUserID(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                           @RequestBody CustomerRequestDTO customerRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(customerService.saveCustomerByUser(user.getUuid(), customerRequestDTO), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/user-api/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerRequestDTO dto) {
        User user = helperService.getUserFromSession();
        CustomerDTO customerDTO = customerService.findByUUID(customerId);

        if (customerDTO == null || user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);

        } else {
            customerService.updateCustomer(customerId, dto, user);
            return new ResponseEntity<>("The object was updated.", HttpStatus.OK);

        }
    }

}
