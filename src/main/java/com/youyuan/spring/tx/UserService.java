package com.youyuan.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  user service
 * @author zhangyu
 * @date 2018-5-8 下午10:48:24
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void inserUser(){
		userDao.insert();
		System.out.println("插入完成........ .. .. .. .. ..");
		int reS=10/0;
	}
	
}
