package service.impl;



import Dao.ClientDao;
import domain.Client;


//实现业务层需要依赖dao的规范
public class ClientServiceDaoimpl  {

	private ClientDao dao;
	
	public void setDao(ClientDao dao) {
		this.dao = dao;
	}
	
	public void rent(Client client) {
		
		dao.rent(client);
		
	}

	public void out(Client client) {
		
		dao.out(client);
		
	}

}
