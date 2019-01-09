package com.xxx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxx.pojo.User;
import com.xxx.service.UserService;

@Controller
@RequestMapping("/User")
public class LoginController {

	@Autowired
	private UserService service;
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		try {
			if(username != null) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				service.login(user);
			}
				

		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "/login";
		}
			return "redirect:/User/list";

	}
}
