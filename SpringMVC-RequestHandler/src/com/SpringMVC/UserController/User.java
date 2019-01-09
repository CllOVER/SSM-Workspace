package com.SpringMVC.UserController;



public class User {

	private Long id;
	private String username;
	private Long age;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + "]";
	}
	
	

	
	
	
	
	
}
