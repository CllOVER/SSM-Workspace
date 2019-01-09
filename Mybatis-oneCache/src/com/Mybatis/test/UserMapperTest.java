package com.Mybatis.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Users;
import com.Mybatis.mapper.UsersMapper;

public class UserMapperTest {

//	查询单条记录
	@Test
	public void testget() {
		
		SqlSession session = MybatisUtil.getSession();
		//获取接口
		UsersMapper mapper =  session.getMapper(UsersMapper.class);
		//查询
		Users user = mapper.get(1L);
		System.out.println(user);
	
		session.clearCache();
		user = mapper.get(1L);
		System.out.println(user);
//默认开启一级缓存，在相同session条件下查询不需要重复调用数据库，关闭后不能查询相关sql的结果 
		//清空缓存后在此使用会调用数据库进行再次查询
		session.clearCache();
		user = mapper.get(1L);
		System.out.println(user);
		session.close();
		
	}

	//查询全部记录
	@Test
	public void testgetAll() {
		SqlSession session = MybatisUtil.getSession();
		UsersMapper mapper = session.getMapper(UsersMapper.class);
		List<Users> list = mapper.getAll();
		session.close();
		for(Users user: list) {
			System.out.println(user);
		}
	}
	
	//查询总数
	@Test
	public void testqueryCount() {
		SqlSession  session = MybatisUtil.getSession();
		UsersMapper mapper = session.getMapper(UsersMapper.class);
		//整形接收总计数量
		int Count = mapper.queryCount();
		System.out.println(Count);
		//一级缓存查询演示
		Count = mapper.queryCount();
		System.out.println(Count);
	}

	//更新操作  除查询以外的操作需要手动提交事务，否则数据不会改变
	@Test
	public void testupdate() {
		SqlSession session = MybatisUtil.getSession();
		UsersMapper mapper = session.getMapper(UsersMapper.class);
		Users user = new Users();
		user.setUsername("重置");
		user.setSalary(new BigDecimal("100"));
		user.setId(3L);
		mapper.update(user);
		//一级缓存查询演示
		mapper.update(user);
		session.commit();
		session.close();
	}
	
	//删除操作
	@Test
	public void testdelete() {
		SqlSession session = MybatisUtil.getSession();
		UsersMapper mapper = session.getMapper(UsersMapper.class);
		mapper.delete(20L);
		//一级缓存查询演示
		mapper.delete(20L);
		session.commit();
		session.close();
	}
	
	//保存操作
	@Test
	public void testsave() {
		SqlSession session = MybatisUtil.getSession();
		UsersMapper mapper = session.getMapper(UsersMapper.class);
		Users user = new Users();
		user.setId(13L);
		user.setUsername("缓存保存");
		user.setSalary(new BigDecimal("200"));
		mapper.save(user);
	
		//一级缓存查询演示
		mapper.save(user);
		session.commit();
		session.close();
	}
}
