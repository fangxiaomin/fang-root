package com.fang;

import com.fang.common.feign.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker  //开启Hystrix的断路器功能
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class,basePackages = "com.fang") // 开启Feign功能
@SpringBootApplication
@EnableDiscoveryClient
public class FangUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangUserApplication.class, args);
    }

}
