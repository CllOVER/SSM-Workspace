package UtilsTest;
//durid连接池的测试配置

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcUtil.xml")
public class jdbcUtilTest {

	@Autowired
	private DataSource ds ;   //封装调用
	@Test
	public void test() throws Exception {
//		ds = new DruidDataSource();
//		ds.setUrl("jdbc:mysql://127.0.0.1:3306/shopping?useUnicode=true&characterEncoding=UTF-8");
//		ds.setPassword("082999");
//		ds.setUsername("root");
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		Connection conn = ds.getConnection();  //获取连接
		String sql = "SELECT * FROM product";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();  //获取结果集
		
		while(rs.next()) {  //指针下移
			System.out.println("productname="+rs.getString("productname")+ "\taddress=" +rs.getString("address")+"\tprice="+
					rs.getLong("price")+"\tkind="+rs.getBigDecimal("kind"));
		}
	
	}

}
