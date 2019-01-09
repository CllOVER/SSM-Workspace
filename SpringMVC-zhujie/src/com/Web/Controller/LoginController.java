package com.Web.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Entry.User;
import com.Service.UserService;

@Controller
@RequestMapping("User")
public class LoginController {

	@Autowired
	private UserService service;
	

	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		User user = service.login(username, password);
		if(user == null) {
			session.setAttribute("msg", "账号或密码错误");
			return "/login";
			
		}
			session.setAttribute("session_in", user);
			return "redirect:/User/list";

	}
}
