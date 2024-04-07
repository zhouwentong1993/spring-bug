package com.wentong.springbug.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.wentong.springbug.mapper") // 指定 MyBatis Mapper 接口的包路径
public class MybatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource()); // 数据源
        // 如果需要自定义 MyBatis 配置文件，可以在这里设置
        // factory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        // 数据源的配置，这里使用 HikariCP 作为连接池
        // 根据实际的数据库配置进行调整
        DruidDataSource config = new DruidDataSource();
        config.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC");
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setUsername("root");
        config.setPassword("root");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return config;
    }
}

