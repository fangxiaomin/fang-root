package com.fang.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.fangeureka.config
 * @author:fxm
 * @createTime:2021/5/28 16:31
 * @version:1.0
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable(); //关闭csrf
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);//开启认证
    }
}
