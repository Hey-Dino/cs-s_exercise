package com.chinasoft.news.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@PropertySource("classpath:db.properties")
public class JdbcConfig {

    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;
    @Value("${jdbc.driver}")
    String driver;

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setPassword(this.password);
        ds.setUsername(this.username);
        ds.setUrl(this.url);
        ds.setDriverClassName(this.driver);
        return ds;
    }

    @Bean
    // 事务管理器 注入容器（spring的容器）
    public PlatformTransactionManager platformTransactionManager(DataSource ds) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(ds);
        return dstm;
    }
}
