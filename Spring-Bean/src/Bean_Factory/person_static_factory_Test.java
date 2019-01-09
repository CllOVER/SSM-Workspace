package Bean_Factory;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置Spring测试类
@RunWith(SpringJUnit4ClassRunner.class)
//配置上下文路径因自动搜索后缀为-context 所以不需要写出路径
@ContextConfiguration
public class person_static_factory_Test {
//自动搜索xml中的Bean
@Autowired
private person_static_factory psf;
	@Test
	public void test() {
		//调用工厂类型创建的对象  验证创建的person_static_factory psf = new person_static_factory();的对象
		person_static_factory psf = person_static_factory.createinstance();
		System.out.println(psf);
	}

}
