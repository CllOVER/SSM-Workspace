package entry;
//模型类
public class User {

	
	private String username;
	private String password;
	private int id;
	private String email;
	
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void User() {
		System.out.println("User构造。。。。。");
	}
	public void  run() {
		System.out.println(username +password  +id +email);
		System.out.println(getClass());   //获取全限定名
	}
	
}
