package com.Mybatis.Service;

import com.Mybatis.Query.EmployeeQueryObject;

public interface EmployeeService {

	//分页
	PageResult result(EmployeeQueryObject qo);
}
