package proxy;
//cblib动态代理针对类不注重针对接口

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
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
		Enhancer en = new Enhancer();  //新疆对象
		en.setSuperclass(service.getClass());   //对哪个类实行代理，继承类所增强
		en.setCallback(this);         //设置增强
		return (T) en.create();     //创建代理（强转类型）
		
		
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
