package org.top.service;

import org.top.model.Payment;

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
