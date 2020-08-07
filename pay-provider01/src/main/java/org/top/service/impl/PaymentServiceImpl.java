package org.top.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.top.mapper.PaymentMapper;
import org.top.model.Payment;
import org.top.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public int createPayment(Payment payment) {
        if(ObjectUtils.isEmpty(payment)){
            return 0;
        }
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(Long id) {
        if(id == null){
            return null;
        }
        return paymentMapper.queryById(id);
    }
}
