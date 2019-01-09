package com.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.TransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-tx.xml")
public class TxTest {

	@Autowired
	private TransferService service;
	@Test
	public void Transfertest() {
		System.out.println("转账操作开始执行");
		service.transf("中国银行", "交通银行", 1000);
		
	}
	
	
}
