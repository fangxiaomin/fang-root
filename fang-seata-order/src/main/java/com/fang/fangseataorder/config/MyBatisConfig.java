package com.fang.fangseataorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan({"com.fang.fangseataorder.dao"})
public class MyBatisConfig {
}
