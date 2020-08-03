package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.model.Payment;
import org.top.response.CommonResult;
import org.top.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public CommonResult createPayment(@RequestBody Payment payment){
        Integer code = paymentService.createPayment(payment);
        return code >0 ? CommonResult.ok() : CommonResult.error();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get")
    public CommonResult queryPaymentById(@RequestParam("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return payment != null ? CommonResult.ok(payment) : CommonResult.error(400,"payment不存在");
    }



}
