package com.youyuan.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试@AutoWired作用在构造器、方法、参数、属性功能   都是从i oc容器获取
 * @author zhangyu
 * @date 2018-5-6 下午8:03:49
 */
@Component
public class Boss {

	private Car car;

	public Car getCar() {
		return car;
	}

	/**
	 * @AutoWired作用在方法上
	 * @param car
	 */
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
		System.out.println("car:"+car);
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
}
