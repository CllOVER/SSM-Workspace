package service.impl;

import dao.IEmployeeDao;
import entry.Employee;
import service.IEmployeeService;

public class IEmployeeServlceimpl implements IEmployeeService {

	
	private IEmployeeDao dao;
	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(Employee emp) {
		dao.save(emp);
		System.out.println("保存成功");
	}

	@Override
	public void update(Employee emp) {
		dao.update(emp);
		throw new RuntimeException("修改错误");
	}

}
