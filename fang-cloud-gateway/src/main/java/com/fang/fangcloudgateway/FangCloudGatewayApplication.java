package com.fang.fangcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FangCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangCloudGatewayApplication.class, args);
    }

}
