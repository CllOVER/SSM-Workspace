package Anno;
//当存在多个bean时
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("person")
public class person {
//用注解代替set等方法自动(先按照类型找) 此为Spring官方注解
	//查找类型+查找name组合方式
	@Autowired
	@Qualifier("cat1")
	//先找name在找类型 ，此为javaee官方注解
//	@Resource(name="cat1")
	//存在多个bean无法选择时 贴上此标签并给值 
	
	
	private Cat c;

	@Override
	public String toString() {
		return "person [c=" + c + "]";
	}
	
	
}
