package com.Mybatis.mapper;

import java.util.List;
import com.Mybatis.Query.EmployeeQueryObject;
import com.Mybatis.domain.Employee;

public interface EmployeeMapper {

	//高级查询  （查询结果）
	List<Employee> AdviceQuery(EmployeeQueryObject qo);
	
	//分页查询 （查询结果集）
	int  PageQuery(EmployeeQueryObject qo);
}
