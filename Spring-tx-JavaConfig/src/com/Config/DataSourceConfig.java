package com.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.alibaba.druid.pool.DruidDataSource;

//数据库的配置文件
@Configuration
@PropertySource("classpath:druid.properties")   //连接配置文件
public class DataSourceConfig {

	//基本配置信息
	@Value("${druid.driverClassName}")
	private String driverClassName;
	@Value("${druid.url}")
	private String url;
	@Value("${druid.username}")
	private String username;
	@Value("${druid.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		//创建连接池对象
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setDriverClassName(driverClassName);
		ds.setPassword(password);
		
		return ds;
		
	}
}
