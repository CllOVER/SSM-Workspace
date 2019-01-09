package com.xxx.service;

import java.util.List;

import com.xxx.pojo.User;

public interface UserService {

	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> list();
	
	void login(User user);
}
