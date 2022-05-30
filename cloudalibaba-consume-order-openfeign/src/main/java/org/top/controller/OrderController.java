package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.PaymentService;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return paymentService.getPayment(id);
    }
}
