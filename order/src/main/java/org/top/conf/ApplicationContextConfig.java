package org.top.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced   (注掉用于验证自己手写的轮训算法)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
