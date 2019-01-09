package Dao.impl;

import org.springframework.stereotype.Repository;

import Dao.ClientDao;
import domain.Client;
@Repository("clientDao")
//dao注解
public class ClientDaoimpl implements ClientDao {

	@Override
	public void rent(Client client) {
		System.out.println("租客租住");
		System.out.println("入住成功！");		
	}

	@Override
	public void out(Client client) {
		System.out.println("租客退房");
		throw new RuntimeException("退房失败，请选择其他方式退房");		
	}
}
