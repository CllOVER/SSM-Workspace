package com.Mybatis.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.Mybatis.Utils.MybatisUtil;
import com.Mybatis.domain.Employee;
import com.Mybatis.mapper.EmployeeMapper;

public class EmployeeTest {

	// 条件查询
	@Test
	public void testlist() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		BigDecimal minprice = new BigDecimal("1000");
		BigDecimal maxprice = new BigDecimal("6000");
		List<Employee> list = mapper.list(minprice, maxprice);
		System.out.println(list);
	}

	// 条件查询
	@Test
	public void testlist2() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		BigDecimal minprice = new BigDecimal("1000");
		BigDecimal maxprice = new BigDecimal("6000");
		List<Employee> list = mapper.list2(minprice, maxprice);
		System.out.println(list);
	}

	@Test
	public void testlistArray() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		BigDecimal minprice = new BigDecimal("10");
		BigDecimal maxprice = new BigDecimal("1000");
		List<Employee> list = mapper.listArray(minprice, maxprice);
		System.out.println(list);
	}

	@Test
	public void testlistCollection() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Integer> emp = mapper.listCollection(list);
		System.out.println(emp);
	}

	@Test
	public void testupdate() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = new Employee();
		emp.setUsername("test1");
		emp.setAddress("test1");
		emp.setPrice(200L);
		emp.setKind(new BigDecimal("20"));
		emp.setId(40);
		// 非查询操作不需要接收
		mapper.update(emp);
		session.commit();
	}

	@Test
	public void testupdate2() {
		SqlSession session = MybatisUtil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Employee emp = new Employee();
		emp.setUsername("test1");
		emp.setAddress("test1");
		emp.setPrice(200L);
		emp.setKind(new BigDecimal("20"));
		emp.setId(40);
		// 非查询操作不需要接收
		mapper.update2(emp);
		session.commit();
	}
}
