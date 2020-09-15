package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.PaymentHystrixService;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") int id){
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") int id){
        return paymentHystrixService.payment_timeout(id);
    }
}
