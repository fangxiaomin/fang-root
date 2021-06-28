package com.fang.common.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger.Level;
/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.common.feign
 * @author:fxm
 * @createTime:2021/6/23 13:30
 * @version:1.0
 */
@Configuration
public class GitHubExampleConfig {

    @Bean
    public Level levl(){
        return Level.FULL;
    }
}
