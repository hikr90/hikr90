package com.korea.dao;

import java.util.List;
import com.korea.vo.TestVO;

public interface TestDao {
	//
	List<TestVO> selectList() throws Exception;
	//
	int updateTest1() throws Exception;
	int updateTest2() throws Exception;
}
