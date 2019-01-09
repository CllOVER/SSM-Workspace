package com.Mybatis.mapper;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.Mybatis.domain.Login;


public interface LoginMapper {

	//使用map进行多参数传递
	Login login(Map<String, Object> params);
	//使用@param注解进行多参数传递
	Login login(@Param("username")String username, @Param("password")String password);


}
