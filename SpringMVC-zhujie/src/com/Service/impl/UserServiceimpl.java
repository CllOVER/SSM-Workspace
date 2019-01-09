package com.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.IUserDao;
import com.Entry.User;
import com.Service.UserService;
@Service
@Transactional
public class UserServiceimpl implements UserService{
	@Autowired
	private IUserDao dao;
	
	
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

	@Transactional(readOnly=true)
	public User get(Long id) {
		dao.get(id);
		return dao.get(id);
	}

	@Transactional(readOnly=true)
	public List<User> list() {
		dao.list();
		return dao.list();
	}

	@Transactional(readOnly=true)
	public User login(String username, String password) {
		dao.login(username,password);
		return dao.login(username,password);
	}

}
