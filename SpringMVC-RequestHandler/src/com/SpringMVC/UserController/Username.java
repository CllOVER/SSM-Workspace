package com.SpringMVC.UserController;

import java.util.ArrayList;
import java.util.List;

public class Username {

	private List<Username> list = new ArrayList<>();

	public void setList(List<Username> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Username [list=" + list + "]";
	}

	public Username(List<Username> list) {
		super();
		this.list = list;
	}
	
	
}
