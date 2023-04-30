package com.korea.dao;

import java.util.List;
import com.korea.vo.TestVO;

public interface TestDao {
	//
	List<TestVO> selectList() throws Exception;
	//
	int testCommit(String testNo) throws Exception;
	int testRollback() throws Exception;
	
}
