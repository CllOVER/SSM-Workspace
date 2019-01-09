package com.dao;

import java.util.List;

import com.entry.User;

public interface UserDao {

	void save(User user);
	
	void update(User user);
	
	void delete(int uid);
	
	User get(int uid);
	
	List<User> list();
}
