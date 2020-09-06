package org.top.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
负载均衡使用随机算法
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
