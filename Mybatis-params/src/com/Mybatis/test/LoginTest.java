package com.Mybatis.test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Login;
import com.Mybatis.mapper.LoginMapper;

public class LoginTest {

	//使用map传递参数
	@Test
	public void testlogin() {
		
		//解决参数只能传单的问题
		//此方式每次使用时都需要创建新的map
		Map<String, Object> params = new HashMap<String,Object>() {
			{
				this.put("username", "11");
				this.put("password", "11");
			}
		};
		SqlSession session = MybatisUtil.getSession();
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		//接收
		Login login = mapper.login(params);
		session.close();
		System.out.println(login);		
	}
	
	
	//使用参数注解传递参数
	@Test
	public void testlogin2() {
		
		SqlSession session = MybatisUtil.getSession();
		//获取getMapper接口
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		Login login =mapper.login("11","11");
		session.close();
		System.out.println(login);
	}
}
