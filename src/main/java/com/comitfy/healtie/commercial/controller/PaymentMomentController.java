package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.PaymentMomentDTO;
import com.comitfy.healtie.commercial.dto.request.PaymentMomentRequestDTO;
import com.comitfy.healtie.commercial.entity.PaymentMoment;
import com.comitfy.healtie.commercial.mapper.PaymentMomentMapper;
import com.comitfy.healtie.commercial.repository.PaymentMomentRepository;
import com.comitfy.healtie.commercial.service.PaymentMomentService;
import com.comitfy.healtie.commercial.specification.PaymentMomentSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("paymentMoment")
public class PaymentMomentController extends BaseCrudController<PaymentMomentDTO, PaymentMomentRequestDTO, PaymentMoment, PaymentMomentRepository, PaymentMomentMapper, PaymentMomentSpecification, PaymentMomentService> {

    @Autowired
    PaymentMomentService paymentMomentService;

    @Autowired
    PaymentMomentMapper paymentMomentMapper;

    @Autowired
    HelperService helperService;

    @Override
    protected PaymentMomentService getService() {
        return paymentMomentService;
    }

    @Override
    protected PaymentMomentMapper getMapper() {
        return paymentMomentMapper;
    }

    @PostMapping("/payment/{orderId}")
    public ResponseEntity<PaymentMomentRequestDTO> saveOrderPayment(@PathVariable UUID orderId, @RequestBody PaymentMomentRequestDTO dto) {
        User user = helperService.getUserFromSession();

        if (user != null) {
            return new ResponseEntity<>(paymentMomentService.saveOrderPayment(orderId, dto, user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
