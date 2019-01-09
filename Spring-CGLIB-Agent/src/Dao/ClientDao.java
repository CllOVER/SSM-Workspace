package Dao;

import domain.Client;

public interface ClientDao {

	void rent(Client client);

	void out(Client client);
}
