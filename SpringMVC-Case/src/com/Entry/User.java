package com.Entry;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

public class User {

	
	private Long id;
	@NotNull(message="用户名长度为2-12位字符")
	@Size( max=12,min=2,message="用户名长度错误，2-12位之间")
	private String username;
	@NotNull(message="密码不能为空")
	@Size( max=12,min=2,message="密码长度错误，2-12位之间")
	private String password;
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	private Date birthday;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
	
}
