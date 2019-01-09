package Springtest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//Spring IoC容器的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//配置上下文路径， 配置文件填写格式为测试类后面加入（-context） 可以免去在注解中加入配置路径
@ContextConfiguration()

public class SpringTest {
	
//按照类型自动去Spring容器中找到bean对象，并设置该字段
@Autowired

private TestBean bean;  //调用相关类
	
	@Test
	public void test() {
		bean.run();
	}
}
