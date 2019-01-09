package com.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.TransferDao;
import com.service.TransferService;

@Transactional
@Service
public class TransferServiceimpl implements TransferService {

	@Autowired
	private TransferDao dao;
	
	
	public void transf(String outid, String inid, int money) {
		
		dao.transfOut(outid, money);  //转出
//		int a=1/0;
		dao.transfIn(inid, money);  //转入
		
	}

}
