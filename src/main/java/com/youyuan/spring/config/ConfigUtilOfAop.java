package com.youyuan.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop步骤
 * 	1、导入jar包
 * 	2、开发业务类
 * 	3、开发切面类,编写切入点表达式(@Pointcut)、通知方法
 * 		通知方法
 * 			1)前置通知(@Before):在目标方法执行前执行
 * 			2)后置通知(@After):在目标方法执行后执行,无论是否发生异常都会执行,类似finally
 * 			3)返回通知(@AfterReturning)：目标方法执行完执行
 * 			4)异常通知(@AfterThrowing):目标方法抛出异常执行
 * 	4、将切面类和业务类注册到ioc容器
 * 	5、使用注解@EnableAspectJAutoProxy标注配置类开启aop注解自动代理模式
 * 
 * @author zhangyu
 * @date 2018-5-7 下午9:52:02
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.youyuan.spring")
public class ConfigUtilOfAop {

	/*@Bean
	public MatchDiv matchDiv(){
		return new MatchDiv();
	}
	
	@Bean
	public LogAspect logAspect(){
		return new LogAspect();
	}*/
}
