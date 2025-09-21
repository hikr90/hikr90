package com.korea.daoImpl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.dao.TestDao;
import com.korea.vo.TestVO;

@Repository
public class TestDaoImpl implements TestDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public TestVO testDaoCheck(String test_id) throws Exception {
		//
		TestVO test_vo = sqlSession.selectOne("test.testCheck", test_id);
		//
		return test_vo;
	}
	
}