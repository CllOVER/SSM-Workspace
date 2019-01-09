package com.Dao;

import java.util.List;
import com.Entry.User;


public interface IUserDao {


	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User get(Long id);
	
	List<User> list();

	User login(String username, String password);
}
