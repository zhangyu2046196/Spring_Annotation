package com.youyuan.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 通过spring  的   FactoryBean工厂模式往ioc容器注册bean
 * @author zhangyu
 * @date 2018-4-28 下午6:05:27
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	/**
	 * 返回注册在ioc容器的组件
	 */
	@Override
	public Color getObject() throws Exception {
		System.out.println("调用ColorFactoryBean的工厂模式创建Color");
		return new Color();
	}

	/**
	 * 返回注册在ioc容器的组件的类型
	 */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	/**
	 * 注册在ioc容器组件是否是单实例的
	 * true单实例  在ioc容器就创建一份
	 * false多实例  在ioc容器每请求一次创建一份
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
