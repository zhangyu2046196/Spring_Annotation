package com.youyuan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyuan.spring.bean.Person;
import com.youyuan.spring.config.ConfigUtil;

public class MainTest {
	public static void main(String[] args) {
		//通过xml配置文件方式获取bean
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
//		Person person=(Person) applicationContext.getBean("person");
//		System.out.println("person:"+person.toString());
		
		//以下通过注解方式组件注册
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigUtil.class);
		System.out.println("person:"+context.getBean("person"));
	}
}
