package org.top.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.interceptor.CustomInterceptor;

@Configuration
public class FeignConfig {

    /**
     * 日志配置
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }

//    /**
//     * feign拦截器配置
//     *
//     */
//    @Bean
//    public RequestInterceptor customInterceptor(){
//        return new CustomInterceptor();
//    }
}
