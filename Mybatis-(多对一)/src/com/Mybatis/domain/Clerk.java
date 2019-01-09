package com.Mybatis.domain;
//职员表

public class Clerk {

	private Long id;
	private String name;
	private Department dept;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public String toString() {
		return "Clerk [id=" + id + ", name=" + name + "]";
	}
	
	
}
