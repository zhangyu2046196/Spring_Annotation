package com.youyuan.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * windows 系统
 * @author zhangyu
 * @date 2018-4-28 下午3:04:15
 */
public class WindowCondition implements Condition {

	/**
	 * 返回true代表满足条件
	 */
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		//获取bean的工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取定义注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//获取运行环境信息
		Environment environment = context.getEnvironment();
		//获取操作系统
		String property = environment.getProperty("os.name");
		if(property.contains("Window")){
			return true;
		}
		return false;
	}

}
