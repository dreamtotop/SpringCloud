package org.top.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");  // 请求来源
        corsConfiguration.addAllowedHeader("*");

        // 允许访问的资源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(
                new PathPatternParser());
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
