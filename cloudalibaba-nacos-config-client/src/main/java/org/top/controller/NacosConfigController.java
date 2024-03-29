package org.top.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 支持nacos的动态刷新功能
public class NacosConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/get/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
