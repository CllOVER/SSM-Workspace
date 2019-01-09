package com.Mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Users;

public class UserTest {

//	查看单个信息
	@Test
	public void testSelect() throws IOException {
//		// 读取全局配置文件 用Resourse的方法读取进入
//		InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
//		// 类似于DataSource的创建
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		// 类似于Connection连接对象
//		SqlSession session = factory.openSession();
		SqlSession session = MybatisUtil.getSession();
		// 接收映射文件的设置的查询
		Users user = session.selectOne("com.Mybatis.domain.Usermapper.get", 1L);
		System.out.println(user);
		// 必须关闭资源
		session.close();

	}

	//查询总计类型为int类型
	@Test
	public void testqueryCount() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			// 接收类型为int类型的
			int rew = session.selectOne("com.Mybatis.domain.Usermapper.queryCount");
			System.out.println(rew);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

//	查看全部信息
	@Test
	public void testgetAll() throws IOException {
		// 必须关闭资源
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			// 接收映射文件的设置的查询
			List<Users> user = session.selectList("com.Mybatis.domain.Usermapper.getAll");
			for (Users u : user) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 必须关闭资源
			session.close();
		}

	}

//	更改操作
	@Test
	public void testupdate() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			Users user = new Users();

			user.setUsername("sssss");
			user.setSalary(new BigDecimal(200));
			user.setId(4L);
			session.update("com.Mybatis.domain.Usermapper.update", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 增删改需要提交事务
//			它们处理DML语句的时候会自动设置autocommit=0;如果DML中不进行手动提交事务，那么最后事务就会进行回滚。
			// DQL操作框架自动开启事务 繁殖DML需要手动开启 并且不再关闭后提交否则回滚，
			session.commit();
			session.close();
		}
	}

	// 删除操作
	@Test
	public void testdelete() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession(); // 调用util类
			session.delete("com.Mybatis.domain.Usermapper.delete", 4L);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit(); // 提交事务
			session.close();
		}
	}

//	添加单个对象
	@Test
	public void testsave() {
		SqlSession session = null;
		Users user = null;

		try {
			user = new Users();
			user.setUsername("林冲");
			user.setSalary(new BigDecimal(300));
			session = MybatisUtil.getSession(); // 调用util类
			System.out.println(user.getId());
			session.insert("com.Mybatis.domain.Usermapper.save", user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
			System.out.println(user.getId());
		}
	}

}
