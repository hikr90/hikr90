package com.korea.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TestVO;

/*	@Repository
 * 		- Dao클래스임을 명시하는 어노테이션
 * 		- 해당 어노테이션이 있는 클래스는 component-scan 태그를 통해서 자동 주입이 가능하다.
 * 		- @Repository("Dao명칭")방식으로도 작성 가능하다.
 */
@Repository
public class TestDaoImpl {
	//
	@Autowired
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//
	public List<TestVO> dao_list(HashMap<String, Object> paramMap){
		//
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}
	
}
