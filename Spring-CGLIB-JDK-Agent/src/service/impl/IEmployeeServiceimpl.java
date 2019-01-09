package service.impl;

import dao.IEmployeeDao;
import domain.Employee;
import service.IEmployeeService;

public class IEmployeeServiceimpl implements IEmployeeService{

	
	private IEmployeeDao dao; //依赖
	
	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}
	
	public void employ(Employee emp) {
		dao.employ(emp);
		
	}

	
	public void dissmiss(Employee emp) {
		dao.dissmiss(emp);
		
	}

	
	public void bonus(Employee emp) {
		dao.bonus(emp);
		
	}

}
