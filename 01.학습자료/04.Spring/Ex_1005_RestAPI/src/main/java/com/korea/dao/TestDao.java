package com.korea.dao;

import java.util.List;

import com.korea.vo.TestVO;

public interface TestDao {
	//
	public List<TestVO> test_list() throws Exception;
	public TestVO test_vo(String test_no) throws Exception;
	//
	public void test_insert(TestVO vo) throws Exception;
	public void test_update(TestVO vo) throws Exception;
	public void test_delete(TestVO vo) throws Exception;
}
