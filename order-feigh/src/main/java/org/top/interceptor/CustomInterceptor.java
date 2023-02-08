package org.top.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {

        logger.info("feign 拦截器!!!");
    }
}
