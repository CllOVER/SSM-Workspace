package com.Mybatis.mapper;
//类似于dao接口
import java.util.List;

import com.Mybatis.domain.Users;
//方法名称要与配置映射文件中的id属性名称一致

public interface UsersMapper {
	
//查询单个记录
	Users get(Long id);
//	查询全部记录
	List<Users> getAll();
//	查询总数
	int queryCount( );
//	更新操作
	void update(Users user);
//	删除操作
	void delete(Long id);
//	保存增加操作
	void save(Users user);
}
