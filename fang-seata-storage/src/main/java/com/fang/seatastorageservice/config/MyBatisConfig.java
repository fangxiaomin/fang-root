package com.fang.seatastorageservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.fang.seatastorageservice.dao"})
public class MyBatisConfig {
}
