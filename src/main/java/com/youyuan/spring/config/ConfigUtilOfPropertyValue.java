package com.youyuan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.youyuan.spring.bean.Person;

/**
 * 属性赋值配置类
 * @author zhangyu
 * @date 2018-5-3 下午10:41:56
 */
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class ConfigUtilOfPropertyValue {
	
	@Bean
	public Person person(){
		return new Person();
	}

}
