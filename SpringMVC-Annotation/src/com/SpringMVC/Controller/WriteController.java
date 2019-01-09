package com.SpringMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//Spring 注解 此需要配置IOC解析器

@Controller
@RequestMapping("/hello")
public class WriteController {
//相当于xml配置的处理器映射器等功能 需要在配置第三方解析器 
	
	
	/*
	 * 请求方式：
	 * postMapping;
	 * GetMapping;
	 * 常用
	 * 
	 * */
	@GetMapping("/1")
	public ModelAndView sayhello() {
		
		System.out.println("hello SpringMVC...");
		ModelAndView mv= new ModelAndView();
		//设置视图名称输入、hello所跳转的界面
		mv.setViewName("/WEB-INF/First.jsp");
		//设置共享数据共享至前台页面
		mv.addObject("msg","你好SpringMVC..");
		return mv;
	}
	
	@GetMapping("/2")
	public ModelAndView sayhello2() {
		
		System.out.println("hello SpringMVC...2");
		ModelAndView mv= new ModelAndView();
		//设置视图名称输入、hello所跳转的界面
		mv.setViewName("/WEB-INF/First.jsp");
		//设置共享数据共享至前台页面
		mv.addObject("msg","你好SpringMVC..2");
		return mv;
	}

}
