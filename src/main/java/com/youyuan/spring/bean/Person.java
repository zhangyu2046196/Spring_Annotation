package com.youyuan.spring.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 实体
 * @author zhangyu
 * @date 2018-4-27 下午9:26:59
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 属性赋值三种方式
	 * 	1、@Value 直接赋值
	 * 	2、在@Value中使用SpEl表达式  #{} 如@Value("#{20-2}") 可以直接输出字面值,也可以输出表达式
	 * 	3、在@Value中引用外部配置文件   
	 * 		用法:
	 * 		  1)在配置类上用@PropertySource指定配置文件   @PropertySource(value={"classpath:/person.properties"})
	 * 		  2)在bean属性上用@Value中使用${} 引入外部配置文件key  如 @Value("${person.nickName}")
	 */
	
	@Value("北京")
	private String userName;
	
	@Value("#{20-2}")
	private int age;
	
	@Value("${person.nickName}")
	private String nickName;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", age=" + age + ", nickName="
				+ nickName + "]";
	}

}
