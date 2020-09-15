package org.top.service;

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
    public String getPaymentInfo_timeout(Integer id){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 "+Thread.currentThread().getName()+"payment_timeout id: "+id;
    }
}
