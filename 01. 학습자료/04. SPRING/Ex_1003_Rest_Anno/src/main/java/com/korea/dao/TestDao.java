package com.korea.dao;

import java.util.List;

import com.korea.vo.TestVO;

public interface TestDao {
	//
	List<TestVO> test_list() throws Exception;
}
