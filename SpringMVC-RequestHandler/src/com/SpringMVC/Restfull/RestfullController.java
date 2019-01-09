package com.SpringMVC.Restfull;
//使用restfull风格传递参数


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/a")
public class RestfullController {

	//普通传递参数的方法
	@RequestMapping("/query")
	public ModelAndView test3(@RequestParam("username")String username) {
		System.out.println("username"+username);
		ModelAndView mv= new ModelAndView();
		return mv;
	}
	
//	Restfull风格 使用get方式
	@RequestMapping(value="/list/{id}")
	public void test2(@PathVariable("id")Long id){
		System.out.println(id);
	}
}
