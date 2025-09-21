package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	/*	Mybatis
	 *		- DB에 접근하는 클래스
	 *		- MybatisConnector 생성자를 통해서 Reader객체를 생성하여 sqlMapConfig에 있는 DB 정보를 가져온다.
	 */
	static MybatisConnector single = null;
	//
	public static MybatisConnector getInstance() {
		if (single == null)
			single = new MybatisConnector();
		return single;
	}
	
	// SqlSessionFactory 생성
	SqlSessionFactory factory = null;
	// 생성자
	public MybatisConnector() {
		/*	Reader
		 *		- 어떤 DB와 맵퍼를 사용하는지에대한 정보가 담겨있는 sqlMapConfig.xml의 내용을 읽기위한 객체
		 *	
		 *		- 맵퍼는 참조해서 가져와 사용하는 참조 파일 (리소스) 라고 부른다.
		 *		- 리소스 객체의 getResourceAsReader 메소드를 통해서 리소스 파일을 읽어온다.
		 */
		try {
			// 리소스 파일 읽어오기
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			
			// 	- 리소스 파일(XML)은 여러 속성(태그)로 구성된 파일로 이러한 형태를 군집(Factory)라고 부른다.
			//	- 이 형태를 읽는 클래스가 SqlSessionFactoryBuilder이다.
			// 	- 빌더 클래스의 build 메소드를 통해서 군집을 해석한다.
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// - 해석된 결과를 getFactory 메소드를 통해서 반환한다.
	// - 반환된 결과는 DAO에서 사용한다.
	public SqlSessionFactory getFactory() {
		return factory;
	}
}
