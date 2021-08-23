package com.fang.fangseataaccount.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan({"com.fang.fangseataaccount.dao"})
public class MyBatisConfig {
}
