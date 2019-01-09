package com.Mybatis.test;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.Mybatis.Query.EmployeeQueryObject;
import com.Mybatis.Service.EmployeeService;
import com.Mybatis.Service.PageResult;
import com.Mybatis.Service.impl.EmployeeServiceimpl;
import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Employee;
import com.Mybatis.mapper.EmployeeMapper;


@SuppressWarnings("all")
public class EmployeeTest {

	@Test
	public void testQuery() {
	
		EmployeeService service = new EmployeeServiceimpl();
		EmployeeQueryObject qo = new EmployeeQueryObject();  //设置条件
			qo.setKeyworld("");
			qo.setMinprice(new BigDecimal(100));
			PageResult result = service.result(qo);   //调用方法
			for(Object re : PageResult.getResult()) {
				System.out.println(re);
			}
			
	}
	
	
	
	@Test
	public void AdviceQuery() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

		// 当输入空字符时应该判定为没有输入
		EmployeeQueryObject qo = new EmployeeQueryObject();
		qo.setKeyworld("");
		qo.setMinprice(new BigDecimal(200));
		qo.setMaxprice(new BigDecimal(1000));
		List<Employee> list = mapper.AdviceQuery(qo);
		for (Employee ee : list) {
			System.out.println(ee);
		}

	}
	
	
	@Test
	public void PageQuery() {
		SqlSession session = MybatisUtil.getSession();
		 EmployeeMapper mapper= session.getMapper(EmployeeMapper.class);
		 EmployeeQueryObject qo = new EmployeeQueryObject();
		 qo.setKeyworld("");
		 qo.setMinprice(new BigDecimal(200));
		 qo.setMaxprice(new BigDecimal(1000));
		int ret = mapper.PageQuery(qo);
	}
}
