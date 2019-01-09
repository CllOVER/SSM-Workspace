package Register.dao.impl;
//注册更新
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Register.dao.IUserDao;
import Register.domain.User;
@Repository   //dao的方式作用于component相同
public class UserDaoimpl implements IUserDao {

	@Autowired
	private DataSource ds;
	
	@Override
	public void save(User user) throws Exception {
		System.out.println("保存操作..");
		Connection conn = ds.getConnection();  //连接
		String sql="INSERT INTO users(username,password) VALUES(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();    //更新sql
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	
}
