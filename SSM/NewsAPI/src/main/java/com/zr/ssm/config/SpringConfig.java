package com.zr.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.zr.ssm.service", "com.zr.ssm.mapper"})
// 第二种扫描方式
/*@ComponentScan(value = "com.chinasoft.mvc01", excludeFilters = {
        // 就是 controller的对象 不会被注入到 spring 容器
        @ComponentScan.Filter(
                // 类型是 注解注入
                type= FilterType.ANNOTATION,
                // 排除的类的类型
                classes = Controller.class
        )
})*/

@Import({JdbcConfig.class, MybatiesConfig.class})
// 开启事务管理
@EnableTransactionManagement
public class SpringConfig {
}
