package org.top.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


/**
 * 网关降级自定义统一异常处理
 */
@Configuration
public class GateWayConfig {

    @PostConstruct
    public void init(){
        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
                Map result = new HashMap();
                result.put("code", HttpStatus.TOO_MANY_REQUESTS.value());
                if(throwable instanceof DegradeException){
                    result.put("message", "服务降级");
                }
                if( throwable instanceof FlowException){
                    result.put("message", "服务限流");
                }
                return ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(result));
            }
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}
