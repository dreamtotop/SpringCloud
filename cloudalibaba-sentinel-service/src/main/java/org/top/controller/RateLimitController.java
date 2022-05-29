package org.top.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.handler.CustomBlockHandler;
import org.top.model.Payment;
import org.top.response.CommonResult;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult ByResource(){
        return new CommonResult(200, "按资源名称进行限流", new Payment(2000L, "2000L"));
    }

    public CommonResult handlerException(BlockException exception){
        return  new CommonResult(444, exception.getClass().getCanonicalName() + "服务繁忙， 请稍后重试");
    }


    @GetMapping("/global/byResource")
    @SentinelResource(value = "global-byResource", blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerGlobalException")
    public CommonResult ByGlobalResource(){
        return new CommonResult(200, "按资源名称进行限流", new Payment(2000L, "2000L"));
    }


    @GetMapping("/custom/byResource")
    @SentinelResource(value = "custom-byResource", blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult ByCustomResource(){
        return new CommonResult(200, "按资源名称进行限流", new Payment(2000L, "2000L"));
    }
}
 