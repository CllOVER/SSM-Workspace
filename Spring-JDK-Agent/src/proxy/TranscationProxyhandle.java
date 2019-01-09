package proxy;
//jdk主要针对具有接口的动态代理 ，无接口下 使用CGLIB代理
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import Transcation.Manager;


@SuppressWarnings("unchecked")
//动态代理
public class TranscationProxyhandle implements InvocationHandler {
	
	private Object service;   //真实对象（交由配置文件进行配置）
	private Manager dao;   //所需要的事务管理类

	public void setService(Object service) {
		this.service = service;
	}
	public void setDao(Manager dao) {
		this.dao = dao;
	}
	
	//创建动态代理(对service中)
	public <T> T getProxy() {
		return (T)Proxy.newProxyInstance(service.getClass().getClassLoader(),   // 类加载器来定义代理类 
				service.getClass().getInterfaces(),  //代理类实现的接口列表
				this);   // 调度方法调用的调用处理函数 
		
		
	}

	//事务的增强具体操作（ proxy传递的是代理类     method是调用的方法，即需要执行的方法；args是方法的参数）
	public Object invoke(Object proxy, Method method, Object[] arg2)  {
		//不能调用proxy 因为底层增强的是equals  toString save update  proxy--》proxy.toString 无限调用导致栈溢出。  getclass不能被子类调用 ，可以使用
		Object ret = null;
		System.out.println(proxy.getClass());
		dao.begin();    //开始事务
		try {
			ret = method.invoke(service, arg2);    //调用真实对象方法
			dao.commmit();
		}catch(Exception e) {
			
			dao.back();  //回滚事务
			e.printStackTrace();
		}
		return ret;
	}

}
