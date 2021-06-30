package com.fang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description:    使用Turbine来聚合hystrix-service服务的监控信息，
 *                     然后我们的hystrix-dashboard服务就可以从Turbine获取聚合好的监控信息展示给我们了。
 *                     聚合收集hystrix实例监控信息的服务
 * author: fxm   https://blog.csdn.net/ThinkWon/article/details/103734664
 * createTime: 2021/6/30 16:08
 **/
@EnableTurbine  //启用Turbine相关功能
@EnableDiscoveryClient
@SpringBootApplication
public class FangUrbineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangUrbineServiceApplication.class, args);
    }

}
