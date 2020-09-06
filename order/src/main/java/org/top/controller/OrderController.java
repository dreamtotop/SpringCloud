package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.top.coonstant.UrlConstant;
import org.top.loadBalence.LoadBalancer;
import org.top.model.Payment;
import org.top.response.CommonResult;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer myLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/consume/payment/lb")
    public String getPayment(){
        List<ServiceInstance> instances = discoveryClient.getInstances("pay-provider");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = myLoadBalance.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/get/serverPort",String.class);
    }
}
