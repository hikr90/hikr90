package com.korea.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TestVO;

/*	REPOSITORY 어노테이션 
		- DAO클래스라는 것을 명시하는 어노테이션
		- REPOSITORY 어노테이션이 있는 클래스는 AUTO-DETECTING으로 자동 생성이 가능하다.
		- (DAO에서 따로 빈객체 생성할 필요가 없다.)
		- ""안에 DAO의 명칭을 명시하는 것이 가능하다.
*/
@Repository
public class TestDAOImpl {
	
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
