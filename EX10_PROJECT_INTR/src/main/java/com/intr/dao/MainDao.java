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
	public List<HashMap<String, Object>> intrMainInqy10101010(Model model, HashMap<String,Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("main.intrMainInqy10101010", paramMap);
		return defaultList;
	}

	// 전체 메뉴 조회
	public List<HashMap<String, Object>> intrMainInqy10103010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("main.intrMainInqy10103010", paramMap);
		return defaultList;
	}

	
	// 시퀀스 (컨텐츠) 생성 
	public HashMap<String, Object> intrMainInqy10301010() throws Exception {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("main.intrMainInqy10301010");
		//
		return defaultInfo;
	}

	// 시퀀스 (사원) 생성 
	public HashMap<String, Object> intrMainInqy10301011() throws Exception {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("main.intrMainInqy10301011");
		//
		return defaultInfo;
	}
	
	// 로그인 사용자 조회
	public EmpVO intrLoginInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		EmpVO defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqy10101010", paramMap);
		//
		return defatulInfo;
	}
	
	// 관리자 계정 조회
	public HashMap<String, Object> intrLoginInqy10201010() {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqy10201010");
		//
		return defatulInfo;
	}

	// 사용자 정보 조회
	public HashMap<String, Object> intrLoginInqy10301010(HashMap<String, Object> paramMap) {
		HashMap<String, Object> defatulInfo = null;
		defatulInfo = sqlsession.selectOne("main.intrLoginInqy10301010", paramMap);
		//
		return defatulInfo;
	}
}
