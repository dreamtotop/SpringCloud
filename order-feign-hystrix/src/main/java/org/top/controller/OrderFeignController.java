package org.top.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.PaymentHystrixService;

@RestController
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderFeignController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") int id){
        return paymentHystrixService.payment_ok(id);
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @GetMapping("/order/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") int id){
        return paymentHystrixService.payment_timeout(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") int id){
        return "我是消费者8070， 支付系统8089繁忙，请稍后重试!";
    }


    @GetMapping("/order/hystrix/timeout/{id}")
    @HystrixCommand
    public String payment_timeout_global(@PathVariable("id") int id){
        int age = 10/0;
        return paymentHystrixService.payment_timeout(id);
    }


    // 配置全局fallback方法
    public String payment_global_fallback(){
        return "系统繁忙，请稍后再试!";
    }
}
