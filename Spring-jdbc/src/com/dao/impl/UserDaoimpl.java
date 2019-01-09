package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.dao.UserDao;
import com.entry.User;

public class UserDaoimpl implements UserDao {

	private JdbcTemplate jdbcTemplate;  //底层是对dataSource进行操作setDataSource(dataSource);  
	//注入dataSource
	public void setdataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void save(User user) {
		jdbcTemplate.update("INSERT INTO user(username,password,email) VALUES(?,?,?)",
				user.getUsername(),user.getPassword(),user.getEmail());
	
	}

	public void update(User user) {
		jdbcTemplate.update("UPDATE user set username = ?,password = ?,email = ? WHERE uid = ?",
				user.getUsername(),user.getPassword(),user.getEmail(),user.getUid());
	}

	public void delete(int uid) {
		jdbcTemplate.update("DELETE FROM user WHERE uid = ?", uid);
	}
//方法中需要使用匿名内部类
	public User get(int uid) {
		List<User> list = jdbcTemplate.query( "SELECT * FROM user WHERE uid = ?", new Object[] { uid }, 
//				new org.springframework.jdbc.core.RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException 
			(rs,rowNum)->{                   //使用lombda创建匿名内部类，直接调用参数
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			
		);
		return list.size() >= 1 ? list.get(0):null;   //判断数据库信息是否大于等于一条 相比于queryforObject方法提供了空数据的方法 后者遇到空数据返回异常。
		
	}

	public List<User> list() {

		return  jdbcTemplate.query("SELECT * FROM user", new Object[] {}, new org.springframework.jdbc.core.RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
	}

}
