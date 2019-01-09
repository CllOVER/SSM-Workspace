package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import entry.Employee;
import service.IEmployeeService;

//调用不经过真实类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Test-context.xml")
public class Testservice {
	
	@Autowired
	private IEmployeeService service;


	@Test
	public void testSave() {
		System.out.println(service.getClass());
		service.save( new Employee());
	}

	
	@Test
	public void testUpdate() {
		System.out.println(service.getClass());
		service.update(new Employee());
	}
}
