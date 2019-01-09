package com.Web.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.util.UserContext;
//登录拦截
public class CheckLoginInterceptor implements HandlerInterceptor {

//	优先执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//web-inf下的目录重定向不能访问
		if(UserContext.getCurrentUser() == null) {
//			response.sendRedirect("/WebContent/WEB-INF/views/login.jsp");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}
}
