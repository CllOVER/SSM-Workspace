package com.Dao;

public interface TransferDao {

	void transfOut(String outid,int money);
	
	void transfIn(String inid,int money);
}
