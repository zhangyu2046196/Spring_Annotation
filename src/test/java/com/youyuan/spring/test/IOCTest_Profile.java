package com.youyuan.spring.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.config.ConfigUtilOfProfile;

/**
 * @Profile注解  用于一样代码在不同环境选择性的注册和使用组件功能
 * @author zhangyu
 * @date 2018-5-6 下午9:01:23
 */
public class IOCTest_Profile {

	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtilOfProfile.class);
	
	@Test
	public void test01(){
		String[] names = context.getBeanNamesForType(DataSource.class);
		for(String name:names){
			System.out.println(name);
		}
	}
	
	/**
	 * 通过代码的方式指定运行环境来测试@Profile
	 */
	@Test
	public void test02(){
		//1、创建一个无参的applicationcontext对象
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//2、指定applicationcontext的运行环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		//3、注册配置文件
		applicationContext.register(ConfigUtilOfProfile.class);
		//4、刷新
		applicationContext.refresh();
		
		
		
		
		
		String[] names = applicationContext.getBeanNamesForType(DataSource.class);
		for(String name:names){
			System.out.println(name);
		}
	}
	
}
