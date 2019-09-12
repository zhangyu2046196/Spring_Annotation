package com.youyuan.spring.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.youyuan.spring.dao.BookDao;

@Service
public class BookService {
	
	/**
	 * 自动装配bean的方式
	 * 1、@AutoWired注解方式装配   (Spring规范定义)
	 * 	如果IOC容器中有多个相同路径和名称的bean,加载顺序如下:
	 * 	1)根据bean的全路径类型加载
	 * 	2)根据引用bean的名称加载
	 * 	3)@Qualifier注解指定bean的名字装配
	 * 2、@Resource注解方式装配      (Java规范 遵循 JSR250)
	 * 		和@AutoWired不同,没有@Qualifier和@Primary,可以通过@Resource(name="bookDao2")的方式指定bean的名字
	 * 3、@Inject注解方式装配   (Java规范  遵从JSR330)
	 * 		需要导入javax.inject包
	 * 		和@AutoWired作用相同
	 */
	//@Qualifier("bookDao2")
	//@Autowired
	//@Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

}
