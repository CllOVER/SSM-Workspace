package com.SpringMVC.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//Spring 注解 此需要配置IOC解析器

@Controller
@RequestMapping("/Spring")
public class WriteController {
//相当于xml配置的处理器映射器等功能 需要在配置第三方解析器 
	
	@RequestMapping("/MVC")
	public ModelAndView view() {
		System.out.println("begin......");
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		list.add(0,"hello");
		list.add(1, "Spring");
		list.add(2, "MVC");
//		加载视图解析器  写入前缀 和后缀 快捷显示视图 
		mv.setViewName("handle");
//		默认输出类型为当前类型的小写   ${string}
		mv.addObject("类型输出:" + getClass());
		mv.addObject("msg",list);
		return mv;
		
	}
	//请求跳转带参数跳转，地址栏不显示页面地址
	@RequestMapping("forword")
	public String forword() {
		ModelAndView mv = new ModelAndView();
		return "forward:/index.html";
	}
	
	//重定向不带参数跳转 ，地址栏显示页面地址
	//重定向之间如果需要共享数据，需通过httpsession中介进行传递
	@RequestMapping("redirect")
	public String redirect() {
		ModelAndView mv = new ModelAndView();
		return "redirect:/index.html";
	}

}
