package com.Mybatis.Utils;
//Mybatis工具类

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory factory = null;

	static {
		try {
			// 加载文件
			InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
			// 获取SQLSessionfactory对象
			factory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(in);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 获取sqlsession对象
	public static SqlSession getSession() {
		return factory.openSession();
	}
}
