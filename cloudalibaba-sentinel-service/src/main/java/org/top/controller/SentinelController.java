package org.top.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {


    @GetMapping("/sentinel")
    public String SentinelService(){
        return "hello sentinel";
    }


    @GetMapping("/sentinel/union")
    public String SentinelUnionService(){
        return "hello sentinel union(测试流控中的资源关联)";
    }

    @GetMapping("/sentinel/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "testHotKey";
    }
    // 降级方法
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "testHotKey fail";
    }
}
