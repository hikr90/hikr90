package com.korea.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TestVO;

@Repository
public class TestDaoImpl {
	
	@Autowired
	SqlSession sqlSession;
	
	//
	public List<TestVO> dao_list(HashMap<String, Object> paramMap){
		//
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}
	
}
