package com.youyuan.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

	public Car(){
		System.out.println("car constructor......");
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		System.out.println("car init method......");
	}
	
	/**
	 * 销毁方法
	 */
	public void destory(){
		System.out.println("car destory method......");
	}
}
