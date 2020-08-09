package org.top.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.top.model.Payment;
import org.top.response.CommonResult;
import org.top.service.PaymentService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    // 服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

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


    @RequestMapping(method = RequestMethod.GET,value = "/discovery")
    public Object discovery(){
        // 获取注册在Eureka上的服务列表
        List<String> services = discoveryClient.getServices();
        for(String service : services) {
            log.info("service :" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("pay-provider");
        for(ServiceInstance instance : instances){
            log.info("service instance : ",instance.getServiceId()+"\t"+instance.getHost()+"\t"
            +instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
