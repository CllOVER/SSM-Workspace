package dao.impl;

import dao.IEmployeeDao;
import domain.Employee;

public class IEmployeeDaoimpl implements IEmployeeDao {

	public void employ(Employee emp) {
		System.out.println("第一天上班");
	}

	public void dissmiss(Employee emp) {
		System.out.println("辞退");
	}

	public void bonus(Employee emp) {
		System.out.println("发年终奖金");
		throw new RuntimeException("公司资金周转困难");
	}

}
