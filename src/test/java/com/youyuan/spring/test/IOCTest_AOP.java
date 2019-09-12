package com.youyuan.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.aop.MatchDiv;
import com.youyuan.spring.config.ConfigUtilOfAop;

/**
 * aop
 * @author zhangyu
 * @date 2018-5-7 下午9:59:00
 */
public class IOCTest_AOP {
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtilOfAop.class);
	
	@Test
	public void test01(){
		MatchDiv matchDiv=context.getBean(MatchDiv.class);
		matchDiv.div(1, 1);
	}
}
