package org.top.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.top.response.CommonResult;

@Component
@FeignClient(value = "PAY-PROVIDER")
public interface PaymentFeignService {

    @RequestMapping(method = RequestMethod.GET,value = "/payment/get")
    CommonResult queryPaymentById(@RequestParam("id") Long id);
}
