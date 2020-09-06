package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.top.model.Payment;
import org.top.response.CommonResult;
import org.top.service.PaymentFeignService;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/order/feign/get")
    public CommonResult<Payment> getById(@RequestParam("id") Long id){
        return paymentFeignService.queryPaymentById(id);
    }
}
