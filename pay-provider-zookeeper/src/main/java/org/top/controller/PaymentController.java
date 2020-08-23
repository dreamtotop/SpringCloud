package org.top.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(method = RequestMethod.GET,value = "/payment/zk")
    public String paymentZk(){

        return "spring cloud with zookeeper : "+serverPort+ UUID.randomUUID().toString();
    }


}
