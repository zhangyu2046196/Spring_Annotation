package com.youyuan.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.bean.Car;
import com.youyuan.spring.config.ConfigUtilOfLifeCycle;

public class IOCTest_LifeCycle {

	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtilOfLifeCycle.class);//ioc容器初始化
	
	@Test
	public void test() {
		System.out.println("ioc容器加载完......");
		//Car car = context.getBean(Car.class);
		context.close();//ioc容器关闭
	}

}
