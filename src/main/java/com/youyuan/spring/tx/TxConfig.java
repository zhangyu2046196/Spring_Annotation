package com.youyuan.spring.tx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 声明式事务 配置
 * 	1、导入spring-jdbc包
 * 	2、配置数据源datasource
 * 	3、配置jdbctemplate
 * 	4、配置事务管理器
 * 	5、业务方法标注为事务 @Transactional
 * 	6、配置类上标注@EnableTransactionManagement注解,打开基于注解的事物管理器
 * @author zhangyu
 * @date 2018-5-8 下午10:37:05
 */
@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
@ComponentScan("com.youyuan.spring.tx")
public class TxConfig {
	
	@Value("${db.user}")
	private String user;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${db.driver}")
	private String driver;
	
	/**
	 * 数据源注册到ioc容器
	 * @return
	 * @throws PropertyVetoException
	 */
	@Bean
	public DataSource dataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/youyuan");
		return dataSource;
	}
	
	/**
	 * jdbctmplate注册  ioc容器
	 * @return
	 * @throws PropertyVetoException
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	/**
	 * 事务管理器注册到ioc容器
	 * @return
	 * @throws PropertyVetoException
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws PropertyVetoException{
		return new DataSourceTransactionManager(dataSource());
	}

}
