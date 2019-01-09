package dao;

import domain.Employee;

public interface IEmployeeDao {

	void employ(Employee emp);
	
	void dissmiss(Employee emp);
	
	void bonus(Employee emp);   //发奖金
}
