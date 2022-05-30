package org.top.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.top.handler.BlockHandler;
import org.top.handler.FallBackHandler;


@RestController
public class CircleBreakerController {

    public static final String ServiceUrl = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consume/fallback/{id}", method = RequestMethod.GET)
    // 处理业务异常(fallbackClass中的服务降级方法为静态方法)
    //@SentinelResource(value = "fallback", fallback = "handlerFallbackException", fallbackClass = FallBackHandler.class)
    // 处理sentinel配置异常
    //@SentinelResource(value = "fallback", blockHandler = "handlerBlockException", blockHandlerClass = BlockHandler.class)
    @SentinelResource(value = "fallback", fallback = "handlerFallbackException", fallbackClass = FallBackHandler.class,
            blockHandler = "handlerBlockException", blockHandlerClass = BlockHandler.class)
    public String fallback(@PathVariable("id") Long id){

        String result = restTemplate.getForObject(ServiceUrl + "/payment/nacos/" + id, String.class, id);

        if(id > 4){
            throw new IllegalArgumentException("参数错误");
        } else if(result == null){
            throw new NullPointerException("记录不存在，空指针异常");
        }
        return result;
    }

}
