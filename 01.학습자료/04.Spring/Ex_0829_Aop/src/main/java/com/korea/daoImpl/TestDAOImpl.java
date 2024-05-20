package com.korea.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.dao.TestDao;
import com.korea.vo.TestVO;

@Repository
public class TestDaoImpl implements TestDao{
	
	@Autowired
	SqlSession sqlSession;
	
	// 테스트 목록 가져오기
	public List<TestVO> selectList(){
		//
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}
	
	// 테스트 커밋
	public int testCommit(String testNo) {
		//
		int res = sqlSession.update("test.test_commit", testNo);
		return res;
	}

	// 테스트 롤백
	public int testRollback() {
		//
		int res = sqlSession.update("test.test_rollback");
		return res;
	}

}
