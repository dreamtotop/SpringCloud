package org.top.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/hello")
    public String sentinel(){
        return "hello sentinel";
    }

    /***
     * 流控规则
     * @return
     */
    @GetMapping("/flow")
    @SentinelResource(value = "flow" , blockHandler = "flowBlackHandler")
    public String flow(){
        return "流控测试";
    }

    public String flowBlackHandler(BlockException ex){
        return "流控限制";
    }
}
