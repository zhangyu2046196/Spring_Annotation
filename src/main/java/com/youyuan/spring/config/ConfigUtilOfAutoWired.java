package com.youyuan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.youyuan.spring.bean.Person;
import com.youyuan.spring.dao.BookDao;

/**
 * bean自动装配
 * @author zhangyu
 * @date 2018-5-4 下午9:38:36
 */
@Configuration
@ComponentScan("com.youyuan.spring")
public class ConfigUtilOfAutoWired {
	
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}

}
