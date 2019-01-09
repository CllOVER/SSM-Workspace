package com.SpringMVC.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//SpringMVC 基于servlet为底层开发       strust2基于fifter为底层开发
//控制器
//实现Controller接口


//引入jar包  2.设置前台控制器  3.写一个类实现Controller接口 4.配置bean文件
public class WriteController implements Controller{

//覆写方法
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("hello SpringMVC...");
		ModelAndView mv= new ModelAndView();
		//设置视图名称输入、hello所跳转的界面
		mv.setViewName("/WEB-INF/First.jsp");
		//设置共享数据共享至前台页面
		mv.addObject("msg","你好SpringMVC..");
		return mv;
	}

}
