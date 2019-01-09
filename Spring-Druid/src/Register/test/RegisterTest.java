package Register.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Register.action.UserAction;
import Register.domain.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcUtil.xml")
public class RegisterTest {
@Autowired
private UserAction UserAction;
	@Test
	public void test() throws Exception {
		UserAction.excute();
	}

}
