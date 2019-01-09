package com.json;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private String username;
	private int id;

	/*	@DateTimeFormat(pattern="yyyy-MM-dd")    丛前台传至后台 
	 * 	@JsonFormat(pattern="yyyy-MM-dd HH-mm-ss" timezone="GTM+8")  丛后台传至前台
	 * */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date birthday;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return birthday;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", birthday=" + birthday + "]";
	}
	
	
	
}
