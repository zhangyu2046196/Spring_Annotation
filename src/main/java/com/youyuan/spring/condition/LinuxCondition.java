package com.youyuan.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * linux 系统
 * @author zhangyu
 * @date 2018-4-28 下午3:08:05
 */
public class LinuxCondition implements Condition {

	@Override
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
		if(property.contains("linux")){
			return true;
		}
		return false;
	}

}
