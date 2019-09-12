package com.youyuan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.youyuan.spring.bean.Color;
import com.youyuan.spring.bean.ColorFactoryBean;
import com.youyuan.spring.bean.Person;
import com.youyuan.spring.bean.Red;
import com.youyuan.spring.condition.LinuxCondition;
import com.youyuan.spring.condition.MyImportBeanDefinitionRegist;
import com.youyuan.spring.condition.MyImportSelector;
import com.youyuan.spring.condition.WindowCondition;

/**
 * @Configuration标记这个类为配置类
 * @Import 作用在类上导入组件,参数是要导入组件的class,默认bean的id值是类的全路径名
 * @author zhangyu
 * @date 2018-4-28 上午11:56:31
 */
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegist.class})
public class ConfigUtil2 {
	
	/**
	 * @Bean 注解bean到ioc容器,默认id的值就是方法名,可以通过@Bean("person")来修改
	 * @Scope 指定bean的作用域,有以下几个值
	 * 		singleton(默认值)：单实例,只创建一个实例,每次IOC容器启动时创建
	 * 		prototype:多实例,IOC容器启动时不创建,每调用一次创建一个
	 * 		request:同一个请求  在web中应用
	 * 		session:同一个会话  在web中应用
	 * @Lazy 懒加载  只是针对@Scope为sigleton单实例的,在IOC容器启动时不加载,调用的时候才会new
	 * @return
	 */
	//@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("创建bean—person.........");
		return new Person("北京", 92);
	}
	
	/**
	 * @Conditional 注解,进行条件判断,满足条件才会将bean注册到ioc容器中
	 * 				此注解可以作用在方法上,作用在方法上代表满足条件此bean才会注册到ioc容器
	 * 				此注解也可以作用在类上,作用在类上代表满足条件此类里面的全部bean才会注册到ioc容器
	 * 
	 * 				用法:需要实现Condition接口
	 * @return
	 */
	@Conditional(WindowCondition.class)
	@Bean("bill")
	public Person person01(){
		return new Person("bill gates", 62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 36);
	}
	
	
	/**
	 * 往IOC容器注册组件的方式
	 * 		1、包扫描(@ComponentScan)+主键注解(@Component、@Service、@Controller、@Repository)
	 * 		2、@Bean注解  默认Id的值是方法名,可以使用@Bean("")来改变bean的名字
	 * 		3、@Import注解 将组件导入到ioc容器
	 * 			1)@Import注解作用在类上,传参数是类名,默认导入的组件bean的id的值是导入的类的全路径名
	 * 			2)@Import按照条件导入组件到ioc容器
	 * 				用法:定义一个类实现ImportSelector接口,重写方法,方法返回值是要导入到ioc容器中 组件的全路径名的数组
	 * 			3)@Import   ImportBeanDefinitionRegist手动注册组件到ioc容器
	 * 				用法:定义一个类实现ImportBeanDefinitionRegist接口
	 * 		4、通过spring的FactoryBean的工厂方式将组件注册到ioc容器中
	 * 				用法:
	 * 					1)定义一个类实现FactoryBean接口,在getObject的方法中new一个要注册到ioc容器中的组件对象
	 * 					2)在配置类通过@Bean将自定义的类注册进来
	 */
	

	/**
	 * 通过spring的FactoryBean工厂方式将组件注册到ioc容器
	 * @return
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
