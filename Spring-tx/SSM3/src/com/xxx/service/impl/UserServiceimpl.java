package com.xxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.UserMapping;
import com.xxx.pojo.User;
import com.xxx.service.UserService;
import com.xxx.util.UserContext;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserMapping mapping; 
	
	public void setMapping(UserMapping mapping) {
		this.mapping = mapping;
	}
	
	@Override
	public void save(User user) {
		mapping.save(user);
	}

	@Override
	public void update(User user) {
		mapping.update(user);	
	}

	@Override
	public void delete(Long id) {
		mapping.delete(id);
		
	}

	@Override
	public User get(Long id) {
		mapping.get(id);
		return mapping.get(id);
	}

	@Override
	public List<User> list() {
		mapping.list();
		return mapping.list();
	}

	@Override
	public void login(User user) {	
	
		//获取当前的信息给current
		User current = mapping.login(user);
		if(current == null) {
			throw new RuntimeException("请输入正确的账号或密码");
		}
		//设置给session
		UserContext.setCurrentUser(current);
	}

}
