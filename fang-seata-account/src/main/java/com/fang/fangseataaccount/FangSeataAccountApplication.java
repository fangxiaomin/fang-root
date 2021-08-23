package com.fang.fangseataaccount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.fang.fangseataorder.dao"})
@EnableDiscoveryClient
@EnableFeignClients
public class FangSeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangSeataAccountApplication.class, args);
    }

}
