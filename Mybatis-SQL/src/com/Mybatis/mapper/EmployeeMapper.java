package com.Mybatis.mapper;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.Mybatis.domain.Employee;

public interface EmployeeMapper {

	// 多条件查询where标签
	List<Employee> list(@Param("minprice") BigDecimal minprice, @Param("maxprice") BigDecimal maxprice);

	// 自定义多条件查询 trim含where标签
	List<Employee> list2(@Param("minprice") BigDecimal minprice, @Param("maxprice") BigDecimal maxprice);

	// 但条件查询 两选一使用choose标签
	List<Employee> listArray(@Param("minprice") BigDecimal minprice, @Param("maxprice") BigDecimal maxprice);

	// 查询内容显示集合中 使用foreach迭代
	List<Integer> listCollection(@Param("id") List<Integer> id);

	// 更新操作set标签
	void update(Employee emp);

	// 自定义更新操作 trim含set属性标签
	void update2(Employee emp);
}
