package com.Mybatis.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Users implements Serializable{

	private Long id;  //编号
	private String username;  // 用户名
	private BigDecimal salary;  //金额
	
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
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", salary=" + salary + "]";
	}
	
	
}
