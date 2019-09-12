package com.youyuan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.youyuan.spring.bean.Person;

/**
 * @Configuration注解标记这个类为配置类
 * @author zhangyu
 * @date 2018-4-27 下午9:34:16
 * 
 * @ComponentScan注解用来包扫描,只要类上标记@Component、@Repository、@Service、@Controller的类都会扫描
 * 	includeFilters:定义扫描规则,只扫描的类
 *  excludeFilters:定义扫描规则,不扫描的类
 * 
 */
@Configuration
@ComponentScan(value="com.youyuan.spring",includeFilters={@Filter(type=FilterType.ANNOTATION,classes={Service.class})},useDefaultFilters=false)
public class ConfigUtil {
	
	/**
	 * 声明一个bean,必须有返回值,返回值类型是实体   id的值就是方法名,也可以通过@Bean("person")去指定
	 */
	@Bean
	public Person person(){
		return new Person("有缘", 30);
	}

}
