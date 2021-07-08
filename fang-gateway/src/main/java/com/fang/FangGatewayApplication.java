package com.fang;

import com.fang.gateway.filter.OwnZuulFilter;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy    //开启网关
@SpringBootApplication
public class FangGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangGatewayApplication.class, args);
    }

    @Bean
    public OwnZuulFilter tokenFilter(){
        return new OwnZuulFilter();
    }

}
