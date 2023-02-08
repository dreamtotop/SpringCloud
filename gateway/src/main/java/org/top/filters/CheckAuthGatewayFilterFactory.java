package org.top.filters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {


    public CheckAuthGatewayFilterFactory(){
        super(CheckAuthGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public GatewayFilter apply(Config config) {
       return new GatewayFilter() {
           @Override
           public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
               String name = exchange.getRequest().getQueryParams().getFirst("name");
               if(StringUtils.isNotBlank(name)){
                   if(config.getName().equalsIgnoreCase(name)){
                       return chain.filter(exchange);
                   }
               }else{
                   exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
                   return exchange.getResponse().setComplete();
               }
               return chain.filter(exchange);
           }
       };
    }


    public static class Config{

        private String name;

        public Config() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
