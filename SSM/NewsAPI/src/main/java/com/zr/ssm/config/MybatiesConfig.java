package com.zr.ssm.config;

import com.github.pagehelper.PageInterceptor;
// import javafx.beans.property.Property;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

public class MybatiesConfig {
    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties property = new Properties();
        property.setProperty("helperDialect", "mysql");
        return pageInterceptor;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds, PageInterceptor pageInterceptor){
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);
        //将分页插件Bean其注入到SqlSessionFactoryBean
        factory.setPlugins(new Interceptor[]{pageInterceptor});

        return factory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zr.ssm.mapper");
        return mapperScannerConfigurer;
    }

}
