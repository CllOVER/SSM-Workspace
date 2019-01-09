package com.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Entry.User;

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
			getsession().invalidate();
		}else {
			getsession().setAttribute(SESSION_IN_USER, current);
		}
	}
	
	public static User getCurrentUser() {
		return (User) getsession().getAttribute(SESSION_IN_USER);
	}
}
