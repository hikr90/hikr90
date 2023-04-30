package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	// MYBATIS를 사용하여 DB 접근하는 클래스
	// SINGLETON
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MybatisConnector single = null;

	public static MybatisConnector getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MybatisConnector();
		//생성된 객체정보를 반환
		return single;
	}
	
	// SqlSessionFactory : sqlMapConfig.xml을 읽기위한 준비 
	SqlSessionFactory factory = null;
	
	// 생성자
	public MybatisConnector() {
		
		// sqlMapConfig.xml의 내용을 읽어온다. (어떤 디비로 접근하고 맵퍼를 쓸지 결정짓기위해서)  (맵퍼 : 디비를 쓸수 있게 해주는 참조파일)
		// ibatis.io (리소스파일은 대부분 참조파일이다.)
		// getResourceAsReader : 읽어올 파일의 경로를 참조
		// 없을 가능성도 있으니 try-catch로 묶는다.
		try {
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
		
			// xml문서를 속성(태그)을 유지한 채(군집한 태그 : 팩토리)로 읽어온다.  
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// dao에 팩토리를 주기위한 get생성
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
}
