package tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//模拟事务管理器
//可以用AOP方式配置


public class txManager {	

//在当前连接点钟获取相关信息
 
	public  void begin(JoinPoint jp) {
		System.out.println("开启事务" );
		System.out.println(jp.getClass());  //打印相关信息 一个方法为一个连接点
	}

	public  void commit() {
		System.out.println("提交事务");

	}
//打印异常信息

	public  void back(Throwable ex) {
		System.out.println("回滚事务="+ ex.getMessage());

	}

	public void close() {
		System.out.println("关闭资源");
	}
	//环绕增强  可综合前面的用法在没有异常的情况下 可以使用
	//调用此方法一个joinpoint的子类ProceedingJoinPoint
	

	public Object around(ProceedingJoinPoint pjp) {
		Object ret = null;
		System.out.println("开启事务" );
		try {
			ret = pjp.proceed();    //获取真实对象的执行方法
			System.out.println("提交事务");
		} catch (Throwable e) {
			System.out.println("回滚事务="+ e.getMessage());
		}finally{
			System.out.println("关闭资源");
		}
		
		return ret;
		
	}
}
