package Transcation;

//事务管理  

public class Manager {

	public void begin() {
		System.out.println("登录网页，开始操作");
	}
	
	public void commmit() {
		System.out.println("开始入住");
	}
	
	public void back() {
		System.out.println("联系房主退房！");
	}
}
