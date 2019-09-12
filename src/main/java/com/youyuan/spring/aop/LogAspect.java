package com.youyuan.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * @author zhangyu
 * @date 2018-5-7 下午9:36:06
 */
@Aspect
@Component
public class LogAspect {

	/**
	 * 切入点
	 * 切入点方法如果在本类直接方法名引用,如果外部类直接方法全路径引用
	 */
	@Pointcut("execution(* com.youyuan.spring.aop.MatchDiv.*(..))")
	public void pointCut(){
		
	}
	
	/**
	 * 前置通知,引入切入点
	 */
	@Before("pointCut()")
	public void logStart(JoinPoint joinpoint){
		System.out.println(joinpoint.getSignature().getName()+"方法前置通知,参数"+Arrays.asList(joinpoint.getArgs()));
	}
	
	/**
	 * 后置通知,引入切入点
	 */
	@After("pointCut()")
	public void logAfter(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"方法后置通知");
	}
	
	/**
	 * 返回通知,获取返回结果
	 */
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(joinPoint.getSignature().getName()+"方法返回通知,结果"+result);
	}
	
	/**
	 * 异常通知,获取异常信息 
	 */
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Object exception){
		System.out.println(joinPoint.getSignature().getName()+"方法异常通知,异常"+exception);
	}
}
