package com.Mybatis.Service.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.Mybatis.Query.EmployeeQueryObject;
import com.Mybatis.Service.EmployeeService;
import com.Mybatis.Service.PageResult;
import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Employee;
import com.Mybatis.mapper.EmployeeMapper;

public class EmployeeServiceimpl implements EmployeeService{

	//获取连接
	SqlSession session = MybatisUtil.getSession();
	EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
	
	//更改EmployeeQueryObject方法实现切换页面方法
	public PageResult result(EmployeeQueryObject qo) {
		int ret =mapper.PageQuery(qo);	 //查询的总数
		if(ret == 0) { //如果表中无数据
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> list = mapper.AdviceQuery(qo); //高级查询所有信息
		return new PageResult(list, ret, qo.getCurrentPage(), qo.getPageSize()) ;
	}

}
