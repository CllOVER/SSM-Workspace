package com.Mybatis.mapper;

import com.Mybatis.domain.Clerk;

public interface ClerkMapper {

	void save (Clerk clerk);

	Clerk get(long id);

	
}
