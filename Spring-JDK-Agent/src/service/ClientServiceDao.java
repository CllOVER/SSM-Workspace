package service;
//业务层
import domain.Client;

public interface ClientServiceDao {

	void rent(Client client);
	
	void out(Client client);
}
