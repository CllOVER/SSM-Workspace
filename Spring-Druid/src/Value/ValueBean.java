package Value;

import org.springframework.beans.factory.annotation.Value;

public class ValueBean {
	
	//读取properties文件中的值
	
	@Value("${Value.username}")
	private String username;

	@Override
	public String toString() {
		return "ValueBean [username=" + username + "]";
	}
		
}
