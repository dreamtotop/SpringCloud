package org.top.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.top.myRule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="pay-provider",configuration = MySelfRule.class)
//@RibbonClients(value = {
//        @RibbonClient(name="pay-provider",configuration = MySelfRule.class)
//})
public class OrderRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonApplication.class,args);
    }
}
