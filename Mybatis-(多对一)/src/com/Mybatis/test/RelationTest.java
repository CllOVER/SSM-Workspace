package com.Mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Clerk;
import com.Mybatis.domain.Department;
import com.Mybatis.mapper.ClerkMapper;
import com.Mybatis.mapper.DepartmentMapper;

public class RelationTest {

	@Test
	public void test() {
		//先保存部门才能在职员表中调出部门信息
		Department d = new Department();
		d.setName("开发部");
		Clerk c1 = new Clerk();
		c1.setName("张三");
		Clerk c2 = new Clerk();
		c2.setName("李四");
		c1.setDept(d);  //部门的属性设置给职员表
		c2.setDept(d);
		SqlSession session = MybatisUtil.getSession();
		ClerkMapper clerk = session.getMapper(ClerkMapper.class);
		DepartmentMapper department = session.getMapper(DepartmentMapper.class);
	
		department.save(d);   //保存部门自动设置id
		clerk.save(c1);  
		clerk.save(c2);
		session.commit();
		session.close();
		
	}
	@Test
	public void testget() {
		SqlSession session = MybatisUtil.getSession();
		ClerkMapper clerk = session.getMapper(ClerkMapper.class);
		DepartmentMapper department = session.getMapper(DepartmentMapper.class);
		/**
		 * 查询时不同表的信息没有封装到属性中时 
		 * 通过额外发送一条sql来查询到相关的属性 交由Mybatis做
		 * */
		Clerk c = clerk.get(1L);
		System.out.println(c.getName());
		System.out.println(c.toString());
		System.out.println(c.getDept());
	}

}
