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
	
	//
	public List<TestVO> test_list() throws Exception {
		//
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}
}
