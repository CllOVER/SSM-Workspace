package com.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Json {
@RequestMapping("/json")
/*
 * RequestBody:用于访问HTTP请求正文。使用HttpMessageConverters 将正文内容转换为声明的方法参数类型。
 * ResponseBody://将一条对象信息转变成一条json信息
 * */
@ResponseBody
	public User test() {
		User user = new User();
		user.setUsername("lihua");
		user.setId(1);
		return user;
		
	}
//将日期封装给javabean中
@RequestMapping("/Date")
public ModelAndView test(User user) {
	ModelAndView mv = new ModelAndView();
	System.out.println(user);
	return null;
	}

}
