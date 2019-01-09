package com.xxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.pojo.User;


public interface UserMapping {

	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> list();

	User login(User user);
}
