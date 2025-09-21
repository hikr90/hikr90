package daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.TestDao;
import vo.TestVO;

public class TestDaoImpl implements TestDao{
	
	/*	SqlSession 	
			- db.properties의 정보와 Mybatis의 정보가 저장되어있는 객체
			- 마이바티스 관련 정보는 mybatis-config.xml에 저장된다.
		
			주입 객체 사용
				- SqlSession 객체는 factory의 정보까지 전부 가지고있으므로 맵퍼에 접근이 가능하다.
				- sqlSession.메소드 방식으로 접근한다.
				- 파라미터는 한가지만 전송 가능하므로, 보통 HashMap등에 저장해서 전송한다.
					(1) 파라미터 사용 시 	: sqlSession.메소드(맵퍼 namespace.쿼리id);
					(2) 파라미터 미사용 시 : sqlSession.메소드(맵퍼 namespace.쿼리id, 파라미터);
	*/
	SqlSession sqlSession;
	
	// 셋터 인젝션
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 메소드
	public List<TestVO> dao_list(HashMap<String, Object> paramMap){
		List<TestVO> list = sqlSession.selectList("test.test_list", paramMap);
		return list;
	}
	
}
