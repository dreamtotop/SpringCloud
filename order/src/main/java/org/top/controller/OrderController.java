package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.top.coonstant.UrlConstant;
import org.top.model.Payment;
import org.top.response.CommonResult;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public CommonResult createOrder(@RequestBody Payment payment){
        if(ObjectUtils.isEmpty((payment))){
            return null;
        }

        return restTemplate.postForObject(UrlConstant.PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/query")
    public CommonResult queryOrder(@RequestParam("id") Long id){
        if(id == null){
            return null;
        }
        return restTemplate.getForObject(UrlConstant.PAYMENT_URL+"/payment/get?id="+id,CommonResult.class);
    }
}