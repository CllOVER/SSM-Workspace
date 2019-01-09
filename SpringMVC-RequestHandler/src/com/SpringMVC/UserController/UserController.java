package com.SpringMVC.UserController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	
	//使用javabean的方式处理多条数据
@RequestMapping("/user")
	public void test(User user) {
		System.out.println(user);
	}


@RequestMapping("/list")
public void test2(@RequestBody List<Username> list) {
	
	System.out.println(list);
}

}
