package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.dto.request.OrderStatusRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.service.OrderService;
import com.comitfy.healtie.commercial.service.ProductService;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("order")
public class OrderController extends BaseCrudController<OrderDTO, OrderRequestDTO, Order, OrderRepository, OrderMapper, OrderSpecification, OrderService> {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductService productService;

    @Autowired
    HelperService helperService;

    @Override
    protected OrderService getService() {
        return orderService;
    }

    @Override
    protected OrderMapper getMapper() {
        return orderMapper;
    }

    @PostMapping("/{productId}")
    public ResponseEntity<OrderRequestDTO> saveOrderByProduct(@PathVariable UUID productId, @RequestBody OrderRequestDTO dto) {

        User user = helperService.getUserFromSession();
        Product product = productService.findEntityByUUID(productId);
        if (product != null) {
            return new ResponseEntity<>(orderService.saveOrderByProduct(productId, dto, user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/order-status-update/{orderId}")
    public ResponseEntity<String> updateOrderStatus(@RequestBody OrderStatusRequestDTO dto, @PathVariable UUID orderId) {
        User user = helperService.getUserFromSession();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);

        } else {
            orderService.updateOrderStatusEnum(dto, orderId);
            return new ResponseEntity<>("The object was updated", HttpStatus.OK);
        }
    }

    @GetMapping("/user-api")
    public ResponseEntity<PageDTO<OrderDTO>> getOrderByUser(@RequestParam int pageNumber, @RequestParam int pageSize) {
        User user = helperService.getUserFromSession();
        PageDTO<OrderDTO> dto = orderService.getOrderByUser(pageNumber, pageSize, user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
