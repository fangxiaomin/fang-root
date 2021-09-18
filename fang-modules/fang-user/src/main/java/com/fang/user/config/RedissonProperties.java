package com.fang.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author:fxm redisson配置
 * @createTime:2021/9/17 15:09
 */
@ConfigurationProperties(prefix = "spring.redis.redisson")
public class RedissonProperties {
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
