package Bean_Factory;
//静态工厂Bean的实例
public class person_static_factory {
//由工厂类型创建对象
	public  static person_static_factory createinstance() {
		
		person_static_factory psf = new person_static_factory();
		return psf;
		
	}
}
