package com.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Dao.IUserDao;
import com.Entry.User;

public class IUserDaoimpl implements IUserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setdataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void save(User user) {
		jdbcTemplate.update("INSERT INTO User(username,password,birthday) VALUES(?,?,?)",
				user.getUsername(),user.getPassword(),user.getBirthday());
		
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("UPDATE User set username = ?,password = ?,birthday = ? WHERE uid = ?",
				user.getUsername(),user.getPassword(),user.getBirthday(),user.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM User WHERE id = ?", id);
	}

	public User get(Long id) {
		List<User> list = jdbcTemplate.query( "SELECT * FROM User WHERE id = ?", new Object[] { id }, 
//				new org.springframework.jdbc.core.RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException 
			(rs,rowNum)->{                   //使用lombda创建匿名内部类，直接调用参数
				User user = new User();
				user.setId(rs.getLong("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
			
		);
		return list.size() >= 1 ? list.get(0):null;   //判断数据库信息是否大于等于一条 相比于queryforObject方法提供了空数据的方法 后者遇到空数据返回异常。
		
	}

	public List<User> list() {

		return  jdbcTemplate.query("SELECT * FROM User", new Object[] {}, new org.springframework.jdbc.core.RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
		});
	}
	@Override
	public User login(String username, String password) {
		List<User> list = jdbcTemplate.query( "SELECT * FROM User WHERE username = ? AND password = ?", new Object[] { username,password }, 
//				new org.springframework.jdbc.core.RowMapper<User>() {
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException 
			(rs,rowNum)->{                   //使用lombda创建匿名内部类，直接调用参数
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		);
		return list.size() >= 1 ? list.get(0):null;   //判断数据库信息是否大于等于一条 相比于queryforObject方法提供了空数据的方法 后者遇到空数据返回异常。
		
	}
	

}
