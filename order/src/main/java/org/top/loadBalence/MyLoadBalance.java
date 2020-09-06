package org.top.loadBalence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
//可以参考源码
@Slf4j
public class MyLoadBalance implements LoadBalancer
{
    private AtomicInteger atomic = new AtomicInteger(0);

    /**
     * CAS实现
     * @return
     */
    private int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomic.get();
            next = current+1;
        }while(!this.atomic.compareAndSet(current,next));
        log.info("******第几次访问 "+next);
        return next;
    }



    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
