package com.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.IUserDao;
import com.Entry.User;
import com.Service.UserService;
import com.util.UserContext;

public class UserServiceimpl implements UserService{
	
	private IUserDao dao;
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void save(User user) {
	dao.save(user);
	}

	@Override
	public void update(User user) {
		dao.update(user);	
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public User get(Long id) {
		dao.get(id);
		return dao.get(id);
	}

	@Override
	public List<User> list() {
		dao.list();
		return dao.list();
	}

	@Override
	public void login(String username, String password) {	
	
		//获取当前的信息给current
		User current = dao.login(username,password);
		if(current == null) {
			throw new RuntimeException("请输入正确的账号或密码");
		}
		//设置给session
		UserContext.setCurrentUser(current);
	}

}
