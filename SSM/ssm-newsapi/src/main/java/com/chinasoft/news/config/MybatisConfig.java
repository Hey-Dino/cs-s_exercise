package com.chinasoft.news.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

public class MybatisConfig {
    @Bean
    // pageHelper 拦截器， 注入到容器
    public PageInterceptor pageInterceptor() {
        PageInterceptor pi = new PageInterceptor();
        Properties props = new Properties();
        // 分页工具的 方言（定义数据库的类型）
        props.setProperty("helperDialect", "mysql");
        pi.setProperties(props);

        return pi;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource ds, PageInterceptor pi ) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);
//        factory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        // 让插件 在 sqlSessionFactory 里面生效
        factory.setPlugins(new Interceptor[]{pi});

        return  factory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage("com.chinasoft.news.mapper");
        return  mapperScanner;
    }
}
