package dao;

import entry.Employee;

public interface IEmployeeDao {

	void save(Employee emp);
	
	void update(Employee emp);
}
