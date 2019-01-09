package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import TranscationMa.Manager_main;
import service.IEmployeeService;

//使用JDK动态代理方式  针对具有接口的service
//底层实则也是实现了service类 底层与静态代理一致
public class EmployeeProxy implements InvocationHandler {

	private IEmployeeService service; // 真实对象
	private Manager_main manager_m;

	public void setService(IEmployeeService service) {
		this.service = service;
	}

	public void setManager_m(Manager_main manager_m) {
		this.manager_m = manager_m;
	}

	@SuppressWarnings("all")
	// 创建代理对象
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(service.getClass().getClassLoader(), // 类加载器
				service.getClass().getInterfaces(), // 增强通过接口
				this); // 通过InvocationHandler操作
	}

	// CGLIB的动态代理 针对类去使用 底层也是实现接口
//	public <T>T getProxy() {
//		Enhancer en = new Enhancer();  //新疆对象
//	en.setSuperclass(service.getClass());   //对哪个类实行代理，继承类所增强
//	en.setCallback(this);         //设置增强
//	return (T) en.create();     //创建代理（强转类型）
//	}
	// 并且替换 InvocationHandler 的包

	// 事务增强具体操作
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = null;
		manager_m.begin();
		try {

			ret = method.invoke(service, args); // 获取
			manager_m.comit();
		} catch (Exception e) {
			manager_m.back();
		}
		return ret;
	}
}
