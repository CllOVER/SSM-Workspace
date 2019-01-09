package com.Web.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Entry.User;
import com.Service.UserService;

@Controller
@RequestMapping("User")
public class LoginController {

	@Autowired
	private UserService service;
	@RequestMapping("/login")
	public String login( String username, String password,HttpSession session ) {
		try {
		
			service.login(username, password);

		}catch(Exception e) {
			session.setAttribute("msg", e.getMessage());
			return "/login";
		}
			return "redirect:/User/list";

	}
}
