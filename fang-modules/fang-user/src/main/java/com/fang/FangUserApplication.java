package com.fang;

import com.fang.common.feign.DefaultFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class,basePackages = "com.fang") // 开启Feign功能
@SpringBootApplication
public class FangUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangUserApplication.class, args);
    }

}
