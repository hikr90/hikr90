package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.intr.vo.EmpVO;

@Repository
public class MainDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 메뉴 조회
	public List<HashMap<String, Object>> intrMainInqyDao1010(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("main.intrMainInqyDao1010", paramMap);
		return defaultList;
	}

	// 전체 메뉴 조회
	public List<HashMap<String, Object>> intrMainInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("main.intrMainInqyDao1020", paramMap);
		return defaultList;
	}

	
	// 시퀀스 생성 
	public HashMap<String, Object> intrMainInqyDao1030() throws Exception {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("main.intrMainInqyDao1030");
		//
		return defaultInfo;
	}

	// 로그인 사용자 조회
	public EmpVO intrLoginInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		EmpVO defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqyDao1010", paramMap);
		//
		return defatulInfo;
	}
	
	// 관리자 계정 조회
	public HashMap<String, Object> intrLoginInqy1020() {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqy1020");
		//
		return defatulInfo;
	}

	// 사용자 정보 조회
	public HashMap<String, Object> intrLoginInqy1030(HashMap<String, Object> paramMap) {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqy1030", paramMap);
		//
		return defatulInfo;
	}
	
	// 목록 건수 조회
	public List<HashMap<String, Object>> intrMainInqyDao1050(HashMap<String, Object> paramMap) {
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("main.intrMainInqyDao1050", paramMap);
		//
		return defaultList;
	}
}
