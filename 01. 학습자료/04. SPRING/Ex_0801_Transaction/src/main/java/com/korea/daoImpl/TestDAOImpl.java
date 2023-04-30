package com.korea.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.dao.TestDao;
import com.korea.vo.TestVO;

@Repository
public class TestDAOImpl implements TestDao{
	
	@Autowired
	SqlSession sqlSession;
	
	// 테스트 목록 가져오기
	public List<TestVO> selectList(){
		//
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}

	// 테스트 변경 1
	public int updateTest1() {
		//
		int res = sqlSession.update("test.test_update1","TEST_0001");
		return res;
	}

	
	public int updateTest2() {
		//
		int res = sqlSession.update("test.test_update2","TEST_0002");
		return res;
	}
}
