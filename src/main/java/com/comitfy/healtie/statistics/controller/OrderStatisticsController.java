package com.comitfy.healtie.statistics.controller;

import com.comitfy.healtie.commercial.dto.OrderDTO;
import com.comitfy.healtie.commercial.dto.request.OrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Order;
import com.comitfy.healtie.commercial.mapper.OrderMapper;
import com.comitfy.healtie.commercial.model.enums.OrderStatusEnum;
import com.comitfy.healtie.commercial.model.enums.PaymentStatusEnum;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.service.OrderService;
import com.comitfy.healtie.commercial.specification.OrderSpecification;
import com.comitfy.healtie.statistics.dto.OrderStatisticsDTO;
import com.comitfy.healtie.statistics.service.OrderStatisticsService;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-statistics")
public class OrderStatisticsController extends BaseCrudController<OrderDTO, OrderRequestDTO, Order, OrderRepository, OrderMapper, OrderSpecification, OrderService> {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    HelperService helperService;

    @Autowired
    OrderStatisticsService orderStatisticsService;


    @Override
    protected OrderService getService() {
        return orderService;
    }

    @Override
    protected OrderMapper getMapper() {
        return orderMapper;
    }
//@RequestHeader(value = "accept-language", required = true) String acceptLanguage,LanguageEnum.valueOf(language)

    @GetMapping("/total-amount/dashboard/user") //kullanıcı için ödediği toplam para miktarı
    public float getTotalAmountByUser(@RequestBody OrderStatisticsDTO orderStatisticsDTO) {
        User user = helperService.getUserFromSession();
        float dto = orderStatisticsService.getTotalAmountOfDate(user.getUuid(), orderStatisticsDTO);
        return dto;
    }

    @GetMapping("/total-order/dashboard/user") // kullanıcı için verdiği sipariş sayısı
    public long getTotalOrderByUser(@RequestBody OrderStatisticsDTO orderStatisticsDTO,
                                    @RequestParam OrderStatusEnum orderStatusEnum) {
        User user = helperService.getUserFromSession();
        long dto = orderStatisticsService.getTotalOrderOfDate(user.getUuid(), orderStatusEnum, orderStatisticsDTO);
        return dto;
    }

    @GetMapping("/total-payment/dashboard/admin") // admin için
    public float getTotalPriceByAdmin(@RequestBody OrderStatisticsDTO orderStatisticsDTO,
                                      @RequestParam PaymentStatusEnum paymentStatusEnum) {
        float dto = orderStatisticsService.getTotalPriceOfDate(paymentStatusEnum, orderStatisticsDTO);
        return dto;
    }

    @GetMapping("/total-order/dashboard/admin") // admin için
    public long getTotalOrderByAdmin(@RequestBody OrderStatisticsDTO orderStatisticsDTO,
                                     @RequestParam PaymentStatusEnum paymentStatusEnum) {

        long dto = orderStatisticsService.getCountOfOrderByDate(paymentStatusEnum, orderStatisticsDTO);
        return dto;
    }

}
