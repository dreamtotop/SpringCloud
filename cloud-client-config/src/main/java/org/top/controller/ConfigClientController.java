package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConfigClientController {


    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private Environment environment;

    @GetMapping("/get/config")
    public String getConfigInfo(){
        String property = environment.getProperty("config.info");
        return configInfo + "---" + property;
    }
}
