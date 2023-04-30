package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	/*	MABATIS
	 		DB에 접근하는 클래스로 MYBATIS 사용전에는 DBSERVICE라는 클래스로 대체했다.
	 		DB에 연결하기위해서는 MYBATISCONNECTOR가 어떤 DB로 접근하는지 경로를 잡아야한다.
	 		여기 예제에서는 TEST_ORACLE이라는 DB에 접근할 것이므로 해당 경로를 참조하고있는 SQLMAPCONFIG를 찾아야한다.
	*/

	// SINGLE-TON PATTERN
	static MybatisConnector single = null;

	public static MybatisConnector getInstance() {
		if (single == null)
			single = new MybatisConnector();
		return single;
	}
	
	// SQLSESSIONFACTORY를 생성하여 SQLMAPCONFIG.XML을 읽기위한 준비를 한다.
	SqlSessionFactory factory = null;
	
	// MYBATISCONNECTOR의 생성자
	// 	(MYBATISCONNECTOR.GETINSTANCE으로 호출하는 생성자)
	public MybatisConnector() {
		
		/*	어떤 DB에 연결하는지, 어떤 MAPPER(DB를 사용할 수 있게해주는 참조 파일)를 사용할 것인지에대한 정보가 담겨있는 SQLMAPCONFIG.XML의 내용을 읽어와야한다. 
			이 내용을 읽어오는데 사용하는 클래스가 RESOURCEASREADER이다.
			
			RESOURCEASREADER (IBATIS.IO)
				기본적으로 이미지나 XML파일등처럼 참조해서 가져와 사용할 수 있는 파일을 리소스(참조)파일이라고 한다.
				해당 클래스는 이러한 참조파일을 읽어오는 역할을 하는데 CHAR타입의 데이터를 읽어오는 경우 사용하기 좋다.
				서버에 연결하기위해서 SQLMAPCONFIG.XML를 읽는다. 
		*/
		
		// XML이 없는 경우를 대비한 TRY-CATCH
		try {
			// READER 객체로 읽는다.
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			
			// READER객체에따라 SQLMAPCONFIG.XML의 내용을 텍스트 내용으로 가져온다.
			// 	이 경우 읽어온 내용이 XML 파일이므로 해석이 있어야한다.
			// 	읽어온 SQLMAPCONFIG.XML 처럼 여러 속성(태그)이 자식의 자식들로 모여있는 형태를 군집(FACTORY)이라고 하는데 이 군집 형태를 해석하기위해서 SQLSESSIONFACTORY의 BUILD메소드가 필요하다.
			
			// BUILD를 통해서 군집 (FACTORY)을 해석한다.
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 군집을 해석한 결과를 DAO에 제공해야 DAO에서 맵퍼로 접근이 가능하므로 DAO에서 FACTORY를 받을 수 있는 GETFACTORY(GETTER) 메소드 생성
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
}
