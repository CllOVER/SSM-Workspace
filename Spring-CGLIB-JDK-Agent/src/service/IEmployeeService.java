package service;

import domain.Employee;

public interface IEmployeeService {


	void employ(Employee emp);
	
	void dissmiss(Employee emp);
	
	void bonus(Employee emp);   //发奖金
}
