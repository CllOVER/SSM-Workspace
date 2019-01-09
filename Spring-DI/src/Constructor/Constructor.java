package Constructor;
//构造方法进行注入

import java.math.BigDecimal;

public class Constructor {

	private String username;
	private int password;
	private BigDecimal id;
	
	//构造方法注入
	public Constructor(String username, int password, BigDecimal id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}


	@Override
	public String toString() {
		return "Constructor [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
	
}
