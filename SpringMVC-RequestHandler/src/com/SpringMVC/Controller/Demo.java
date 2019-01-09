package com.SpringMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo {

	@RequestMapping("demo/{id}/{name}")
	public void demo(@PathVariable int id,@PathVariable String name) {
		System.out.println(id+name);
	}
}
