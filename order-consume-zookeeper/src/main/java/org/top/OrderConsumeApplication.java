package org.top;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumeApplication.class,args);
    }
}