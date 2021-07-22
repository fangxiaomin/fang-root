package com.fang.fangcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:   使用Java Bean配置  网关路由...与配置文件的配置功能一致。。。
 * @projectName:fang-root
 * @see:com.fang.fangcloudgateway.config
 * @author:fxm
 * @createTime:2021/7/20 17:48
 * @version:1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("path_route1", r -> r.path("/user/getWayTest")
                                .uri("http://localhost:7071/user/getWayTest"))
                .route(
                        "path_route2", r -> r.path("/user/getByUsername")
                                .uri("http://localhost:7071/user/getByUsernameTest")
        ).build();
    }
}
