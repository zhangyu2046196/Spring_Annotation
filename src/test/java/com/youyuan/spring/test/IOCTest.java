package com.youyuan.spring.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.youyuan.spring.bean.Blue;
import com.youyuan.spring.bean.Person;
import com.youyuan.spring.config.ConfigUtil2;

public class IOCTest {
	
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigUtil2.class);//加载配置类

	@Test
	public void test1() {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();//获取容器bean
		for(String name:beanDefinitionNames){
			System.out.println("name:"+name);
		}
	}
	
	@Test
	public void test2(){
		System.out.println("IOC容器 启动.........");
		Person person1=(Person) context.getBean("person");
		Person person2=(Person) context.getBean("person");
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person1==person2);
	}
	
	@Test
	public void test3(){
		String[] names = context.getBeanNamesForType(Person.class);//获取ioc容器中所有bean
		ConfigurableEnvironment environment = context.getEnvironment();//获取运行环境信息
		String property = environment.getProperty("os.name");//获取操作系统
		System.out.println(property);
		for(String name:names){
			System.out.println(name);
		}
		Map<String, Person> ofType = context.getBeansOfType(Person.class);
		System.out.println(ofType);
	}
	
	@Test
	public void testImport(){
		printBeanNames(context);
		Blue bean = context.getBean(Blue.class);
		System.out.println(bean);
		Object bean2 = context.getBean("colorFactoryBean");
		System.out.println("通过FactoryBean工厂的方式注册组件类型"+bean2.getClass());
	}
	
	/**
	 * 抽取公用方法打印ioc容器中所有bean名字
	 * @param context
	 */
	private void printBeanNames(AnnotationConfigApplicationContext context){
		if(context!=null){
			String[] names=context.getBeanDefinitionNames();//获取ioc容器中所有组件
			for(String name:names){
				System.out.println(name);
			}
		}
	}

}
