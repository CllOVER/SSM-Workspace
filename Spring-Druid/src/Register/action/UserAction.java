package Register.action;
//表现层

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import Register.domain.User;
import Register.service.IUserService;

@Controller   //controller控制层
public class UserAction {
//需要使用到的接口
	@Autowired
	private IUserService se;
	
	

	public void setSe(IUserService se) {
		this.se = se;
	}



	public void excute() throws Exception {
		System.out.println("注册请求。。");
		se.register(new User());
	}
	
	
}
