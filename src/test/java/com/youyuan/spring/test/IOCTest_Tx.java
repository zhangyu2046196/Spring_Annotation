package com.youyuan.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.tx.TxConfig;
import com.youyuan.spring.tx.UserService;

public class IOCTest_Tx {
	
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TxConfig.class);
	
	@Test
	public void test(){
		UserService userService = context.getBean(UserService.class);
		userService.inserUser();
	}

}
