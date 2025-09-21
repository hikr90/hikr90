package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.SawonVO;

public class SawonDAO {
	//
	static SawonDAO single = null;
	//
	public static SawonDAO getInstance() {
		if (single == null)
			single = new SawonDAO();
		return single;
	}
	
	/* SqlSessionFactory
	 *	- SqlSession객체를 생성하기위한 Factory 객체
	 *	- 맵퍼 (XML)를 읽기위한 필요한 MybaticsConnector 객체를 싱글톤으로 생성한다.
	 *	- 생성된 객체는 openSession 메소드를 통해서 SqlSession을 가져와 쿼리문장을 사용하는데 쓴다.
	 */
	SqlSessionFactory factory;
	
	// 생성자
	public SawonDAO() {
		// - DAO 클래스가 객체화되는 순간 바로 Factory의 정보를 받아오도록 생성자 안에서 Factory 객체를 받는다.
		// - MybatisConnector 클래스의 생성자가 싱글톤을 통해서 sqlMapConfig.xml의 맵퍼 정보를 받아오게 된다.
		// - Factory가 접속하려는 계정 ORACLE_TEST의 정보를 받은 접근 준비 완료 상태가 된다.
		factory = MybatisConnector.getInstance().getFactory();
	}
	
	// 목록 조회
	public List<SawonVO> select(){
		List<SawonVO> list = null;
		
		/*	sqlSession
		 *		- Sql 쿼리 문장을 처리하는 객체
		 *		- 맵퍼로 접근하는 권한을 가지고있는 Factory객체가 openSession 메소드를 통해서 맵퍼 접근 권한을 부여한다.
		 *		- SqlSession메소드에는 쿼리문을 수행할 수 있는 여러 메소드가 있다.
		 *			(1) selectList
		 *			(2) selectOne
		 *			(3) insert
		 *			(4) update
		 *			(5) delete 등
		 *
		 *			- 해당 메소드를 사용할 때는 메소드(XML의 NameSpace값.쿼리문 id값)의 형태로 동작시킨다.
		 *			- 만약 해당 id값이 없는 경우 오류가 발생한다.
		 *			- 쿼리문이 수행되면 close메소드를 통해서 SqlSession객체를 종료해준다.
		 *
		 *			- 쿼리문에 파라미터를 추가하는 경우 메소드 내 변수를 추가한다. (단, 쿼리문의 속성에 parameterType이 있어야한다.)
		 *			- 파라미터는 단 한가지만 가능하므로 여러 변수 값이 필요한 경우 Map에 여러 값을 담아 전송하는 방식으로 해야한다.
		 */
		SqlSession sqlSession = factory.openSession(); 
		list = sqlSession.selectList("sawon.sawon_list");
		sqlSession.close();
		return list;
	}
	
	// 부서 번호에따라서 사원 리스트 출력
	public List<SawonVO> select(int deptno){
		List<SawonVO> list = null;
		SqlSession sqlSession = factory.openSession(); 
		list = sqlSession.selectList("sawon.sawon_list_no", deptno);
		sqlSession.close();
		return list;
	}
}
