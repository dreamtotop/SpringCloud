package org.top.service;

import org.springframework.stereotype.Component;

/**
 * 统一为接口方法进行异常处理
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{

    public String payment_ok(int id) {
        return "PaymentHystrixFallbackService fall back -- payment_ok";
    }

    public String payment_timeout(int id) {
        return "PaymentHystrixFallbackService fall back -- payment_timeout";
    }
}
