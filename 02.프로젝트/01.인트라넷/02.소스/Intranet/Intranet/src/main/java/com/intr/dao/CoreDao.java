package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoreDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 메뉴 조회
	public List<HashMap<String, Object>> intrCoreInqy1011(HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1011", paramMap);
		return defaultList;
	}

	// 전체 메뉴 조회
	public List<HashMap<String, Object>> intrCoreInqy1021(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1021", paramMap);
		return defaultList;
	}
	
	// 목록 수 조회
	public List<HashMap<String, Object>> intrCoreInqy1051(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1051", paramMap);
		return defaultList;
	}
}
