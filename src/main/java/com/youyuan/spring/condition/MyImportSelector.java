package com.youyuan.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义importselector,返回 需要导入ioc容器的类的全路径名的数组
 * @author zhangyu
 * @date 2018-4-28 下午4:03:58
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * AnnotationMetadata  可以获取到标记@Import注解的类的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		return new String[]{"com.youyuan.spring.bean.Blue","com.youyuan.spring.bean.Yellow"};
	}

}
