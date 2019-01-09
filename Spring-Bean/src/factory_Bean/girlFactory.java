package factory_Bean;

import org.springframework.beans.factory.FactoryBean;
//实现对factoryBean的接口的实现Bean的配置 该方法在集成中会重点使用 
public class girlFactory implements FactoryBean<girl> {
//可实现set字段  并在配置文件中使用
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	//实例工厂方法
	@Override
	public girl getObject() throws Exception {
		System.out.println(username);
		girl g = new girl();
		return g;
	}
//返回的类型
	@Override
	public Class<?> getObjectType() {
	
		return girl.class;
	}
	
	//默认实现单例模式(Singeletion单例模式)
	public  boolean isSingleton() {
		return true;
	}
}
