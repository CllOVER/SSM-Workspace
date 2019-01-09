package service.impl;

import Dao.ClientDao;
import domain.Client;
import service.ClientServiceDao;

//实现业务层需要依赖dao的规范
public class ClientServiceDaoimpl implements ClientServiceDao {

	private ClientDao dao;
	
	public void setDao(ClientDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void rent(Client client) {
		
		dao.rent(client);
		
	}

	@Override
	public void out(Client client) {
		
		dao.out(client);
		
	}

}
