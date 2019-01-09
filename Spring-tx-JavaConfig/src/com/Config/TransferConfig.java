package com.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//事务管理
@Configuration  //javaConfig配置
@Import(DataSourceConfig.class) //导入数据库配置
@ComponentScan   //IOC扫描
@EnableTransactionManagement   //开启事务管理
public class TransferConfig {

	@Bean
	public DataSourceTransactionManager txManager( DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
		
	}
}
