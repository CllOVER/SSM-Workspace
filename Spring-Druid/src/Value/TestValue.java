package Value;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcUtil.xml")
public class TestValue {

	@Autowired
	private ValueBean bean;
	@Test
	public void test() {
		System.out.println(bean);
	}

}
