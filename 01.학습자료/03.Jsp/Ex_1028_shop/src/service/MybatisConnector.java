package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	static MybatisConnector single = null;
	//
	public static MybatisConnector getInstance() {
		if (single == null)
			single = new MybatisConnector();
		return single;
	}
	//
	SqlSessionFactory factory = null;
	
	// 생성자
	public MybatisConnector() {
		try {
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//
	public SqlSessionFactory getFactory() {
		return factory;
	}
}
