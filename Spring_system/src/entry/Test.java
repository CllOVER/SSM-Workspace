package entry;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//BeanFactory 具有延迟初始化的特点 在web开发中不经常使用
//ApplicationContext 不具有延迟初始化， （可在Bean中配置是否延迟 用lazy -----） 在服务器启动中就已经开始初始化了  提高性能


public class Test {

	@org.junit.Test
	public void test() {
		//创建IoC容器
		Resource resource = new ClassPathResource("ApplicationContext.xml");
		//获取IoC对象
		
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		System.out.println("-----------------------------");
		User user = (User) factory.getBean("User",User.class);
		System.out.println(user);
		//调用
		user.run();
		
	}
	/*
	 * 
	 * 使用Spring Beans 的条件必须包含一个无参构造。
	 * 
	 */
	@org.junit.Test
	public void test2() {
		//创建IoC容器
	
		
		ApplicationContext ac  = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获取IoC对象
		//第一种签名方式；根据getBean的名字 
		//Object getBean(String name)
//		User user = (User) ac.getBean("User");    (配置文件类型 id较少时可以使用 ，较多时不建议使用)
		
		
		//第二种签名方式 ；根据类型查找       警告： 当配置文件中存在多个Bean下 且 类型相同的id不同的bean  出现错误 
		//<T> T getBean(Class<T> requiredType) 
		//错误提示：org.springframework.beans.factory.NoUniqueBeanDefinitionException:
//		User user = ac.getBean(User.class);
		
		//第三种签名方式： 根据类型和getBean的id一起查找  边查找id 并检查 类型是否相同  (安全) 
		// <T> T getBean(String name, @Nullable Class<T> requiredType)
		
		System.out.println("---------------------------------");
		User user = ac.getBean("Users",User.class);
		System.out.println(user);
		user.run();
		
	}

}
