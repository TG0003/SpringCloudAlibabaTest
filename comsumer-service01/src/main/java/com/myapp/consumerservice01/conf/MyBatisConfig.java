package com.myapp.consumerservice01.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.myapp.consumerservice01.dao"})
public class MyBatisConfig {
}
