package com.korea.dao;

import java.util.List;

import com.korea.vo.TestVO;

public interface TestDao {
	//
	TestVO test_vo(String test_no) throws Exception;
	List<TestVO> test_list() throws Exception;
}
