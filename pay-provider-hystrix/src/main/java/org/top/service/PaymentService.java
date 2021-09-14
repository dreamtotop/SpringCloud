package org.top.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    // ********************* 服务降级 ************************

    /**
     * 正常方法
     * @param id
     * @return
     */
    public String getPaymentInfo_ok(Integer id){
        return "线程池 "+Thread.currentThread().getName()+"payment_ok id: "+id;
    }

    /**
     * 异常方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getPaymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String getPaymentInfo_timeout(Integer id){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 "+Thread.currentThread().getName()+" payment_timeout id: "+id;
    }

    public String getPaymentInfo_timeoutHandler(Integer id){
        return "服务降级：线程池 "+Thread.currentThread().getName()+"8089系统繁忙，请稍后再试: "+id;
    }




    // ************************  服务熔断  *******************************

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack", commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少跳闸
    })
    public String  paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        //String serial = UUID.randomUUID().toString();
        String serialNumber = IdUtil.randomUUID();
        return Thread.currentThread().getName() + "\t" + " 调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallBack(@PathVariable("id") Integer id){

        return "id 不能为负数，请稍后再试 id" + id;
    }
}
