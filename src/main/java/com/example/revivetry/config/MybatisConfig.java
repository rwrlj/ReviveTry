package com.example.revivetry.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author rwr
 */
@Configuration
@MapperScan(basePackages = {"com.example.**.mapper"})
public class MybatisConfig {
}
