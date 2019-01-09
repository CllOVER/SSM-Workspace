package com.xxx.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xxx.pojo.User;

//封装上下文用户信息
public class UserContext {

	private static final String SESSION_IN_USER = "session_in";
	
	//获取session
	public static HttpSession getsession() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		
	}
	
	//设置当前用户信息
	public static void setCurrentUser(User current) {
		
		if(current == null) {
			getsession().invalidate();  //销毁
		}else {
			getsession().setAttribute(SESSION_IN_USER, current);  //设置session
		}
	}
	
	public static User getCurrentUser() {
		return (User) getsession().getAttribute(SESSION_IN_USER);  //获取当前session
	}
}
