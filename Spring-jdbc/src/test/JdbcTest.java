package test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dao.UserDao;
import com.entry.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-jdbc.xml")
public class JdbcTest {
@Autowired
private UserDao dao;
//保存操作
	@Test
	public void testsave() {
	User user = new User();
	user.setUsername("ceshi2");
	user.setPassword("ceshi2");
	user.setEmail("ceshi2");
	dao.save(user);
	}
//更新操作
	@Test
	public void testupdate() {
		User user = new User();
		user.setUsername("2");
		user.setPassword("2");
		user.setEmail("2");
		user.setUid(64);
		dao.update(user);
	}
//删除操作
	@Test
	public void testdelete() {
		dao.delete(66);
	}
//查询单个信息
	@Test
	public void testget() {
		User user = dao.get(99);
		System.out.println(user);
		
	}
//查询所有信息
	@Test
	public void testLIst() {
		List<User> list = dao.list();
		for(User user : list) {
			System.out.println(user);
		}
	}
}
