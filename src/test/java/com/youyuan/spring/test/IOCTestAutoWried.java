package com.youyuan.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.bean.Boss;
import com.youyuan.spring.config.ConfigUtilOfAutoWired;
import com.youyuan.spring.dao.BookDao;
import com.youyuan.spring.service.BookService;

public class IOCTestAutoWried {
	
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtilOfAutoWired.class);
	
	@Test
	public void test01(){
		//BookDao bookDao = context.getBean(BookDao.class);
		//System.out.println("bookDao:"+bookDao);
		
		BookService bookService = context.getBean(BookService.class);
		System.out.println("bookService:"+bookService);
	}
	
	@Test
	public void test02(){
		
		Boss boss=(Boss) context.getBean("boss");
		
		System.out.println(boss);
		
		System.out.println("boss getCar:"+boss.getCar());
	}

}
