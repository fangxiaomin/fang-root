package com.fang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.servlet.annotation.WebListener;

@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker  //开启Hystrix的断路器功能
@SpringBootApplication
@ServletComponentScan //开启  Servlet可以直接通过@WebServlet注解自动注册  Filter可以直接通过@WebFilter注解自动注册 Listener可以直接通过@WebListener 注解自动注册
public class FangHystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangHystrixServiceApplication.class, args);
    }

}
