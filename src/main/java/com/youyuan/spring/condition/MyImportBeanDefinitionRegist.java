package com.youyuan.spring.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.youyuan.spring.bean.RainRow;

/**
 * 自定义类 手动注册bean到ioc容器
 * @author zhangyu
 * @date 2018-4-28 下午4:34:22
 */
public class MyImportBeanDefinitionRegist implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata:可以获取标记@Import类的说有注解信息
	 * BeanDefinitionRegistry:需要注册的实体
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,BeanDefinitionRegistry registry) {
		RootBeanDefinition bean=new RootBeanDefinition(RainRow.class);
		registry.registerBeanDefinition("rainRow", bean);
	}

}
