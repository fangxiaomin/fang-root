package com.fang.common.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: RestTemplate是用来发送请求的，@LoadBalanced表明这个RestTemplate开启负载均衡功能，默认使用轮训算法
 * @projectName:fang-root
 * @see:com.fang.common.Config
 * @author:fxm
 * @createTime:2021/6/28 16:04
 * @version:1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
