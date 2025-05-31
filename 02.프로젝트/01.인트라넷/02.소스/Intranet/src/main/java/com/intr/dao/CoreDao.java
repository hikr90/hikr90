package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class CoreDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 메뉴 조회
	public List<HashMap<String, Object>> intrCoreInqy1011(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1011", paramMap);
		return defaultList;
	}

	// 전체 메뉴 조회
	public List<HashMap<String, Object>> intrCoreInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1021", paramMap);
		return defaultList;
	}
	
	// 시퀀스 채번
	public HashMap<String, Object> intrCoreInqy1041() {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("core.intrCoreInqy1041");
		return defaultInfo;
	}
	
	// 시퀀스 저장
	public int intrCoreInqy1042(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("core.intrCoreInqy1042", paramMap);
		return resInt;
	}
	
	// 목록 수 조회
	public List<HashMap<String, Object>> intrCoreInqy1051(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("core.intrCoreInqy1051", paramMap);
		return defaultList;
	}
}
