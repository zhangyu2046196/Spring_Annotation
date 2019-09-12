package com.youyuan.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
/**
 * 测试bean生命周期使用实现InitializingBean的接口重写afterPropertiesSet方法来指定初始化方法
 * 				   使用实现DisposableBean的接口重写destory方法来指定销毁方法
 * @author zhangyu
 * @date 2018-5-2 下午10:57:23
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
	
	public Cat(){
		System.out.println("cat constructor......");
	}

	/**
	 * 销毁方法
	 */
	public void destroy() throws Exception {
		System.out.println("cat destory......");

	}

	/**
	 * 初始化方法
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("cat init......");

	}

}
