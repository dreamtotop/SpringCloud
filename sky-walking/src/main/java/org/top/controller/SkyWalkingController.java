package org.top.controller;

import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.SkyWalkingService;

import javax.annotation.Resource;
/**
 * @Trace 会将标记方法记录到链路中
 * @Tag  记录方法返回值/参数等
 */
@RequestMapping("/sky")
@RestController
public class SkyWalkingController {

    @Resource
    private SkyWalkingService skyWalkingService;

    @RequestMapping("/get")
    // 记录方法的返回值
    @Trace
    @Tag(key = "get", value = "returnedObj")
    public String get(){
        return skyWalkingService.get();
    }

    @RequestMapping("/select/{id}")
    @Trace
    @Tags({@Tag(key = "select", value = "returnedObj"),
            @Tag(key = "select", value = "arg[0]")})
    public String select(@PathVariable("id") Long id){
        return "success " + id;
    }
}
