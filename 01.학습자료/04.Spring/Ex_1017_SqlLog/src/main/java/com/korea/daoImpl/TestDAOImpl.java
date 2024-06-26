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
		String test_no = "TEST_0001";
		List<TestVO> list = sqlSession.selectList("test.test_list", test_no);
		return list;
	}

}
