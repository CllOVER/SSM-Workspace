package factory_Bean;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class girlFactoryTest {
	
@Autowired
private girl g;
private girl g2;

	@Test
	public void test() {
		System.out.println(g);
		System.out.println(g2);
		
	}
}
