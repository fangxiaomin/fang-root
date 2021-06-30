package com.fang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * @Description:   通过使用Hystrix Dashboard监控单个Hystrix实例来了解下它的使用方法。
 * author: fxm              展示hystrix实例监控信息的仪表盘
 * createTime: 2021/6/30 16:07
 **/
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class FangHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangHystrixDashboardApplication.class, args);
    }

}
