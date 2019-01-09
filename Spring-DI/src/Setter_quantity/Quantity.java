package Setter_quantity;
//常量注入方式
public class Quantity {

	private String username;
	private String password;
	private int id;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Quantity [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
}
