package com.Mybatis.domain;

import java.math.BigDecimal;

public class Employee {

	private int id;
	private String username;
	private String address;
	private Long price;
	private BigDecimal 	kind;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public BigDecimal getKind() {
		return kind;
	}
	public void setKind(BigDecimal kind) {
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", address=" + address + ", price=" + price + ", kind="
				+ kind + "]";
	}
	
	
}
