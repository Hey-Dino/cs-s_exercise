package com.chinasoft.news.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.chinasoft.news.service" })
@Import({JdbcConfig.class, MybatisConfig.class})
// 开启事务管理
@EnableTransactionManagement
public class SpringConfig {
}