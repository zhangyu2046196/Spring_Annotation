package com.youyuan.spring.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * user dao
 * @author zhangyu
 * @date 2018-5-8 下午10:45:41
 */
@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(){
		String sql="insert into T_APP_USER (USER_NAME,AGE) values (?,?)";
		jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0, 6),Math.random());
	}
}
