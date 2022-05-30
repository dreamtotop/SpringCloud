package org.top.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackServiceImpl implements PaymentService{


    @Override
    public String getPayment(Integer id) {
        return "服务繁忙， 请稍后再试 " + id;
    }
}
