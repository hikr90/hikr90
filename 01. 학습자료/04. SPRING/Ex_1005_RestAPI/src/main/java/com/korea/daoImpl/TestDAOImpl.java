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
	public List<TestVO> test_list(){
		List<TestVO> list = sqlSession.selectList("test.test_list");
		return list;
	}
	
	// 
	public TestVO test_vo(String test_no){
		//
		TestVO vo = sqlSession.selectOne("test.test_vo", test_no);
		return vo;
	}
	
	//
	public void test_insert(TestVO vo) {
		//
		sqlSession.insert("test.test_insert", vo);
	}
	
	//
	public void test_update(TestVO vo) {
		//
		sqlSession.update("test.test_update", vo);
	}

	//
	public void test_delete(TestVO vo) {
		//
		sqlSession.delete("test.test_delete", vo);
	}

}
