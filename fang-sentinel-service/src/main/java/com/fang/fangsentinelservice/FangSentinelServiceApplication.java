package com.fang.fangsentinelservice;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
//@MapperScan(basePackages = {"com.fang.fangsentinelservice.mapper"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FangSentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangSentinelServiceApplication.class, args);
    }

    /**
     * @Description: 使用@SentinelRestTemplate来包装下RestTemplate实例：
     * 
     **/
    @Bean
//    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
