package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.SawonVO;

public class SawonDAO {
	// SINGLE-TON PATTERN
	static SawonDAO single = null;

	public static SawonDAO getInstance() {
		if (single == null)
			single = new SawonDAO();
		return single;
	}
	
	// SQLSESSION 객체를 생성하기위한 FACTROY 
	// 맵퍼 (XML)를 읽기위해서 필요한 FACTORY가 DAO클래스에서 어떤식으로 접근할지 알기위해서 FACTORY객체 생성
	SqlSessionFactory factory;
	
	// SAWON DAO 생성자로 바로 접근하도록 설정
	public SawonDAO() {

		/*	DAO.GETINSTANCE에서 바로 FACTORY의 정보를 받아올 수 있도록 생성자 안에서 FACTORY를 받는다. 
				DAO 생성자 실행시, MYBATIS CONNECTOR의 GETINSTANCE를 SINGLETON으로 생성하면서 MYBATISCONNECTOR의 생성자가 호출이 된다.
				
				MYBATISCONNECTOR에서는
				MYBATISCONNECTOR의 생성자가 호출이 되었으니 READER를 통해서 SQLMAPCONFIG.XML의 데이터를 읽고
				SQLSESSIONFACTORYBUILDER를 통해서 구조를 해석한 뒤 그 정보를 DAO에게 GETFACTORY로 전달하게 된다. 
		*/
		
		// FACTORY가 접속하려는 계정 ORACLE_TEST의 정보를 받은 상태 (접근 준비 완료)
		factory = MybatisConnector.getInstance().getFactory();
	}
	
	// 사원 리스트
	public List<SawonVO> select(){
		List<SawonVO> list = null;
		
		/*	SQLSESSION
				SQL처리 객체 (SQL쿼리 문장을 사용할 수 있게하는 객체)
				맵퍼로 접근하는 권한을 가지고있는 FACTORY가 OPENSESSION이라는 메소드를 통해서 SQLSESSION에게 맵퍼 접근 권한을 부여한다.
		*/
		SqlSession sqlSession = factory.openSession(); 
		
		/*		SQLSESSION에는 CRUD, SELECTONE(한 정보만 검색)등의 쿼리문 동작을 수행하는 메소드가 존재한다.
		 			SQLSESSION의 메소드인 SELECTLIST를 통해서 LIST변수로 SQL문장의 결과값을 받도록 한다. */
		
		/*	NAMESPACE.SQL문장 ID	
		  		SQLSESSION을 통해서 SQL쿼리문을 동작하게되면 SQLSESSION은 맵퍼의 XML파일중 SAWON이라는 식별자(NAMESPACE)를 가진 XML파일을 찾는다. 
				만약 XML파일 중에 NAMESPACE가 SAWON이 없다면 오류가 난다.
				SAWON이라는 XML을 찾은 뒤 그 안에 있는 SQL문장중 SAWON_LIST라는 명칭의 ID를 가진 SQL코드를 실행하게 된다.
		*/
		list = sqlSession.selectList("sawon.sawon_list");
		
		// SQLSESSION 역시 DB작업이 완료되면 CLOSE로 종료해줘야한다.
		sqlSession.close();
		
		// 메소드를 사용한 SERVLET으로 LIST결과를 리턴한다.
		return list;
	}
	
	
	// 부서 번호에따라서 사원 리스트 출력
	public List<SawonVO> select(int deptno){
		List<SawonVO> list = null;

		SqlSession sqlSession = factory.openSession(); 
		
		// 파라미터로 값을 넘기는 경우 (실행할 XML페이지, 넘기는 파라미터)로 값을 넘긴다고 명시해야한다.
		// 단, 단일로 보내는 값은 반드시 하나만 가능하다. (해결 방안으로는 MAP등에 여러 값을 넣어 전송하는 방식이 있다.)
		list = sqlSession.selectList("sawon.sawon_list_no", deptno);
		sqlSession.close();
		return list;
	}
}
