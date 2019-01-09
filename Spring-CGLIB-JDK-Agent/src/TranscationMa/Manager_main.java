package TranscationMa;
//第一种事务管理
public class Manager_main {

	public void begin() {
		System.out.println("开启事务");
	}
	public void comit() {
		System.out.println("进行事务");
	}
	public void back() {
		System.out.println("回滚事务");
	}
	
}
