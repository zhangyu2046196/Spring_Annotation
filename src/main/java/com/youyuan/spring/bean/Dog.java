package com.youyuan.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * 测试bean初始化、销毁方法
 * 	在初始化方法使用@Postconstrctor注解指定初始化方法
 * 	在销毁方法使用@Predestory注解指定销毁方法
 * @author zhangyu
 * @date 2018-5-2 下午11:20:11
 */
@Component
public class Dog {
	
	public Dog(){
		System.out.println("dog constructor......");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("dog init......");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("dog destory......");
	}

}
