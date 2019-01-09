package SetterTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import Setter_Connection.Connection;
import Setter_Object.Person;
import Setter_quantity.Quantity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class Setter_Test {
	
	//Quantity常量注入测试
	@Autowired
	private Quantity q;
	@Test
	public void testQuantity() {
		System.out.println(q);
	}
	
	//Object对象注入测试
	@Autowired
	private Person p;
	@Test
	public void testObject() {
		System.out.println(p);
		
	}
	
	//Connection集合注入测试
	@Autowired
	private Connection c;
	@Test
	public void testConnection() {
		System.out.println(c);
	}
	
}
