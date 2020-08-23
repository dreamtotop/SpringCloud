package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String INVOKE_URL="http://pay-provider-zookeeper";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume/zookeeper")
    public String getResult(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
