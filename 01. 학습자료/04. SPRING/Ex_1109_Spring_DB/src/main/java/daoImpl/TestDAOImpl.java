package daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TestDao;
import vo.TestVO;

public class TestDAOImpl implements TestDao{
	
	/*	SQLSESSION 	
		- DB.PROPERTY의 정보와 마이바티스의 정보가 저장되어있는 객체
		- 마이바티스의 정보는 MYBATIS-CONFIG.XML에 저장된다.
	*/
	SqlSession sqlSession;
	
	// 셋터 인젝션
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// DAO 메소드
	public List<TestVO> dao_list(HashMap<String, Object> paramMap){
		/*	SQLSESSION 객체의 사용
				- SQLSESSION 객체는 FACTORY의 정보까지 전부 가지고있으므로 맵퍼(DB)에 접근할 수 있다.
				- 방식은 메소드 내 파라미터 ("맵퍼의 NAMESPACE.쿼리 ID값") 로 접근한다.
				- 파라미터가 추가되는 경우 ("맵퍼의 NAMESPACE.쿼리 ID값","파라미터")로 접근하며 파라미터는 한가지 타입만 가능하므로 HASHMAP등이 자주 사용된다.
		*/
		List<TestVO> list = sqlSession.selectList("test.test_list", paramMap);
		return list;
	}
	
}
