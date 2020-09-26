package org.top.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

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
}
