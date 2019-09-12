package com.youyuan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.youyuan.spring.bean.Car;

/**
 * bean的生命周期,调用初始化方法和销毁方法
 * 
 * 可以自定义初始化方法和销毁方法,当bean的生命周期运行到指定阶段时会自动调用指定的方法
 * 
 * 调用初始化方法:
 * 	 1、bean的作用域@Scope指定为Singleton(单实例)时,IOC容器启动完成时创建bean时调用初始化方法
 *   2、bean的作用域@Scope指定为Prototype(多实例)时,IOC容器启动完成调用getBean方法是调用初始化方法
 * 调用销毁方法:
 * 	 1、bean的作用域@Scope指定为Singletion(单实例)时,当IOC容器关闭(applicationContext.close())时调用销毁方法
 *   2、bean的作用域@Scope指定为Prototype(多实例)时,当IOC容器关闭(applicationContext.close())时不会调用销毁方法,只能手动调用销毁方法
 *   
 * 指定bean的生命周期(调用初始化方法和销毁方法)的方式
 * 	 1、@Bean的方式(类似xml配置bean中的init-method和destory-method),@Bean(initMethod="init",destoryMethod="destory")
 * 	 2、bean实现InitializingBean接口重写afterPropertiesSet方法指定初始化方法,实现DisposableBean接口重写destory方法指定销毁方法
 * 	 3、bean的初始化方法上使用@Postconstructor注解指定初始化方法和在bean的销毁方法上使用@Predestory注解指定销毁方法
 * 	 4、BeanPostProcessor后置处理器
 * 		bean实现BeanPostProcessor接口重写
 * 
 * @author zhangyu
 * @date 2018-5-2 下午10:19:43
 */
@ComponentScan("com.youyuan.spring")
@Configuration
public class ConfigUtilOfLifeCycle {
	
	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car(){
		return new Car();
	}

}
