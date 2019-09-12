package com.youyuan.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 测试BeanPostProcessor后置处理器
 * @author zhangyu
 * @date 2018-5-2 下午11:37:25
 */
@Component
public class MyBeanProcessor implements BeanPostProcessor {
	
	public MyBeanProcessor(){
		System.out.println("MyBeanProcessor constructor......");
	}

	/**
	 * 在bean的初始化之后执行
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+" MyBeanProcessor destory......");
		return bean;
	}

	/**
	 * 在bean的初始化之前执行
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+" MyBeanProcessor init......");
		return bean;
	}

}
