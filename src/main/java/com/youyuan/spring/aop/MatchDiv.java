package com.youyuan.spring.aop;

import org.springframework.stereotype.Component;

/**
 * aop业务类
 * @author zhangyu
 * @date 2018-5-7 下午9:35:42
 */
@Component
public class MatchDiv {
	
	public int div(int i,int j){
		return i/j;
	}

}
