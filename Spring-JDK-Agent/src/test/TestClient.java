package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Client;
import proxy.TranscationProxyhandle;
import service.ClientServiceDao;
import service.impl.ClientServiceDaoimpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:TestClient-context.xml")
public class TestClient {
@Autowired
private TranscationProxyhandle service;

//class com.sun.proxy.$Proxy17  获取到的动态代理对象
	@Test
	public void Renttest() {	
		 ClientServiceDao proxy = service.getProxy();   //获取动态代理
		 
		 proxy.rent( new Client());  //调用rent方法 
	}
	
	@Test
	public void Outtest() {
		ClientServiceDao proxy = service.getProxy();
		 
		proxy.out(new  Client());
	}

}
