package Bean_Life;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用Spring测试能够自动根绝配置文件获取初始化和销毁方法
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("MyDataSourceTest-context.xml")
public class MyDatSourceTest {
	
@Autowired
private MyDataSource myDataSource1;

	@Test
	public void test() {
		System.out.println(myDataSource1);
		
		myDataSource1.run();
		
	}
//不用Spring测试方法，资源不能正常关闭
	//最好的方法把 ApplicationContext 替换成 ClassPathXmlApplicationContext  并使用ac.registerShutdownHook(); 方法销毁
	@Test
	public void test2() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("Bean_Life/MyDataSourceTest-context.xml");
		MyDataSource my = (MyDataSource) ac.getBean("MyDataSource",MyDataSource.class);
		my.run();
		//最好的方式：把spring线程作为JVM的子线程 使用 ctx.registerShutdownHook();
		ac.registerShutdownHook();  
	}
}
