package org.top.loadBalence;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义的负载均衡算法
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
