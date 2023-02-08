package org.top.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * sentinel 关联流控规则测试
 */
@Service
public class UserService {

    @SentinelResource(value = "getUser", blockHandler = "blocHandlerGetUser")
    public String getUser(){
        return "admin";
    }

    public String blocHandlerGetUser(BlockException e){
        return "流控用户";
    }
}
