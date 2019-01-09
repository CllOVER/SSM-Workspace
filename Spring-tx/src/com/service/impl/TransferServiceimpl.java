package com.service.impl;

import com.Dao.TransferDao;
import com.service.TransferService;

public class TransferServiceimpl implements TransferService {

	private TransferDao dao;
	
	public void setDao(TransferDao dao) {
		this.dao = dao;
	}
	
	public void transf(String outid, String inid, int money) {
		
		dao.transfOut(outid, money);  //转出
		int a=1/0;
		dao.transfIn(inid, money);  //转入
		
	}

}
