package com.Dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Dao.TransferDao;
@Repository
public class TransferDaoimpl implements TransferDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public void transfOut(String outid, int money) {
		jdbcTemplate.update("UPDATE bank_transfer set accounts = accounts  - ? WHERE id = ?",  money,outid);
	}

	
	public void transfIn(String inid, int money) {
		jdbcTemplate.update("UPDATE bank_transfer set accounts = accounts  + ? WHERE id = ?", money,inid);
	}

}
