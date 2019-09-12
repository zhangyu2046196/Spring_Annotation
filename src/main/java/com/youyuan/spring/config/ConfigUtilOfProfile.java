package com.youyuan.spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Profile  一样的代码根据不同的环境来选择的激活和使用组件,组件在@Profile指定的环境上才能注册到ioc容器中
 * 	此处用数据源为例
 * 		开发数据源
 * 		测试数据源
 * 		生产数据源
 * @Profile使用方法,只有标注@Profile的组件才会受影响,不标注的在任何环境都会被注册到ioc容器中
 * 	1)在运行是指定参数-Dspring.profiles.active=test  指定运行环境
 * 	2)通过代码的方式
 * @author zhangyu
 * @date 2018-5-6 下午8:43:06
 */
@Configuration
@PropertySource("classpath:/datasource.properties")
public class ConfigUtilOfProfile {
	
	@Value("${db.user}")
	private String user;
	
	@Value("${db.driver}")
	private String driver;
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource getDataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass(driver);
		return dataSource;
	}
	
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource getDataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lover2");
		dataSource.setDriverClass(driver);
		return dataSource;
	}
	
	@Profile("pro")
	@Bean("proDataSource")
	public DataSource getDataSourcePro(@Value("${db.password}") String password) throws PropertyVetoException{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/youyuan");
		dataSource.setDriverClass(driver);
		return dataSource;
	}

}
