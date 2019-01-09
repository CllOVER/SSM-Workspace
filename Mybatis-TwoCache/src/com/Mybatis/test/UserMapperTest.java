package com.Mybatis.test;

import java.math.BigDecimal;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Users;
import com.Mybatis.mapper.UsersMapper;

public class UserMapperTest {

//	查询单条记录
	@Test
	public void testget() throws InterruptedException {
		SqlSession session1 = MybatisUtil.getSession();
		SqlSession session2 = MybatisUtil.getSession();
		UsersMapper mapper1 =  session1.getMapper(UsersMapper.class);
		UsersMapper mapper2 =  session1.getMapper(UsersMapper.class);
		//查询
		Users user1 = mapper1.get(58L);
		System.out.println(user1);
		Thread.sleep(3000);
		mapper1 =  session1.getMapper(UsersMapper.class);
		user1 = mapper1.get(58L);
		System.out.println(user1);
	
		session1.close();
		
		
	//查询操作下 使用一级缓存不失效，不重复查sql语句,使用session1.clearCache()清理了缓存将重新发送sql。
	
	}

	
	//查询总数
	@Test
	public void testqueryCount() {
		SqlSession session1 = MybatisUtil.getSession();
		SqlSession session2 = MybatisUtil.getSession();
		UsersMapper mapper1 =  session1.getMapper(UsersMapper.class);
		UsersMapper mapper2 =  session1.getMapper(UsersMapper.class);
		
		int Count1 = mapper1.queryCount();
		System.out.println(Count1);
		
		int Count2 = mapper2.queryCount();
		System.out.println(Count2);
		session1.close();
		session2.close();
	}

	//更新操作  除查询以外的操作需要手动提交事务，否则数据不会改变
	@Test
	public void testupdate() {
		SqlSession session1 = MybatisUtil.getSession();
		SqlSession session2 = MybatisUtil.getSession();
		UsersMapper mapper1 =  session1.getMapper(UsersMapper.class);
		UsersMapper mapper2 =  session1.getMapper(UsersMapper.class);
		Users user = new Users();
		user.setUsername("重置");
		user.setSalary(new BigDecimal("100"));
		user.setId(34L);
		
		mapper1.update(user);	
		session1.commit();
		
		//验证了一级缓存只存在Session
		mapper2.update(user);
		session2.commit();
		session1.close();
		session2.close();
		
	}
	
	//删除操作
	@Test
	public void testdelete() {
		SqlSession session1 = MybatisUtil.getSession();
		SqlSession session2 = MybatisUtil.getSession();
		UsersMapper mapper1 =  session1.getMapper(UsersMapper.class);
		UsersMapper mapper2 =  session1.getMapper(UsersMapper.class);
		mapper1.delete(1L);
		session1.commit();
		//一级缓存查询演示
		mapper2.delete(1L);
		session2.commit();
		//验证session不同sql的查询将重新发送sql
		session1.close();
		session2.close();
	}
	
	//保存操作
	@Test
	public void testsave() {
		SqlSession session1 = MybatisUtil.getSession();
		SqlSession session2 = MybatisUtil.getSession();
		UsersMapper mapper1 =  session1.getMapper(UsersMapper.class);
		UsersMapper mapper2 =  session1.getMapper(UsersMapper.class);
		Users user = new Users();
		user.setUsername("缓存保存");
		user.setSalary(new BigDecimal("200"));
		
		mapper1.save(user);
		System.out.println(user);
		session1.commit();
		System.out.println(user);
		
		//验证一级缓存只存在于同一session中
		
		mapper2.save(user);
		System.out.println(user);
		session2.commit();
		System.out.println(user);
		session1.close();
		session2.close();
	}
}
