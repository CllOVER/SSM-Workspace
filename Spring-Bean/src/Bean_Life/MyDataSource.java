package Bean_Life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//模拟资源文件进行生命周期的测试
//实现接口的类在调用InitializingBean接口是 自动复写一个初始化方法 相比Bean的配置文件中init-method 属性 要优先

//<bean id="MyDataSource" class="Bean_Life.MyDataSource" init-method="init" destroy-method="destroy"></bean>

@Component("myDataSource")
//@Scope("prototype") 默认下  销毁资源    多例下不销毁资源
public class MyDataSource implements InitializingBean {

	public MyDataSource() {
		System.out.println("创建对象...");
	}
	@PostConstruct
	public void init(){                     //此初始化方式不依赖Spring
		System.out.println("init初始化资源");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("销毁资源");
	}
	public void run() {
		System.out.println("资源加载中...");
	}
	//初始化配置
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean的接口方法初始化资源...");
		
	}
}
