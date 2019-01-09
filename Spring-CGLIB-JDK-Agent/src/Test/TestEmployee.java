package Test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import domain.Employee;
import proxy.EmployeeProxy;
import service.IEmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:TestEmployee-context.xml")
public class TestEmployee {

	@Autowired
	private EmployeeProxy proxy;
	
	@Test
	public void employtest() {
		 IEmployeeService service = proxy.getProxy();
		service.employ(new Employee());
	}
	@Test
	public void dismisstest() {
		 IEmployeeService service = proxy.getProxy();
		service.dissmiss(new Employee());
	}
	@Test
	public void bonustest() {
		 IEmployeeService service = proxy.getProxy();
		service.bonus(new Employee());
	}

}
