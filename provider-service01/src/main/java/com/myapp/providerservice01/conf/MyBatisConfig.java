package com.myapp.providerservice01.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.myapp.providerservice01.dao"})
public class MyBatisConfig {
}
