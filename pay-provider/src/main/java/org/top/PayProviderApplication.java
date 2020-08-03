package org.top;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayProviderApplication.class,args);
    }
}
