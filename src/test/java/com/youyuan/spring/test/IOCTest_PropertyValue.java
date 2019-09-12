package com.youyuan.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youyuan.spring.bean.Person;
import com.youyuan.spring.config.ConfigUtilOfPropertyValue;

public class IOCTest_PropertyValue {
	
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtilOfPropertyValue.class);
	
	@Test
	public void test01(){
		printlnBeanName(context);
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}
	
	private void printlnBeanName(AnnotationConfigApplicationContext context){
		String[] names = context.getBeanDefinitionNames();
		for(String name:names){
			System.out.println(name);
		}
	}

}
