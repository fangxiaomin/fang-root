package com.fang;

import com.fang.common.feign.DefaultFeignConfiguration;
import com.fang.common.feign.GitHubExampleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: 如果不写包名默认找启动类包下面的feignClient   basePackages  去寻找feign的位置
 * author: fxm
 * createTime: 2021/6/17 17:22
 **/
@EnableFeignClients(defaultConfiguration = GitHubExampleConfig.class,basePackages = "com.fang.order") // 开启Feign功能
@EnableDiscoveryClient
@SpringBootApplication
public class FangOrderApplication {

    public static void main(String[] args) {
       try {
           SpringApplication.run(FangOrderApplication.class, args);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
