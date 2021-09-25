package org.top.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 代码配置 (配置文件配置)
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_guonei", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"))
                .route("path_route_guoji", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji")).build();
        return  routes.build();
    }

}
