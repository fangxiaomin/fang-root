package com.fang.common.feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:     // period=100 发起当前请求的时间间隔，单位毫秒
 *         // maxPeriod=1000 发起当前请求的最大时间间隔，单位毫秒
 *         // maxAttempts=5 最多请求次数，包括第一次
 * @projectName:fang-root
 * @see:com.fang.common.exception
 * @author:fxm
 * @createTime:2021/6/23 14:28
 * @version:1.0
 */
@Configuration
public class DefaultFeignConfiguration {
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(1000,3000,3);
    }
}
