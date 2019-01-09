package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Client;
import proxy.TranscationProxyhandle;

import service.impl.ClientServiceDaoimpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:TestClient-context.xml")
public class TestClient {

	@Autowired
	private TranscationProxyhandle ts;
//class com.sun.proxy.$Proxy17  获取到的动态代理对象
	//CGLIB的代理class service.impl.ClientServiceDaoimpl$$EnhancerByCGLIB$$945f2ed2
	@Test
	public void Renttest() {	
		ClientServiceDaoimpl service = ts.getProxy();
		service.rent(new Client());
	}
	
	@Test
	public void Outtest() {
		ClientServiceDaoimpl service = ts.getProxy();
		service.out(new Client());
	}

}
