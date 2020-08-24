package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String URL = "http://pay-provider-consul";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String getConsulResult(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}
