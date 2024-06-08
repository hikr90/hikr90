package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AuthDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1010", paramMap);
		return defaultList;
	}

	// 권한 상세 조회
	public HashMap<String, Object> intrAuthInqy1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.intrAuthInqy1020", paramMap);
		//
		return defaultInfo;
	}
	
	// 메뉴 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1030", paramMap);
		return defaultList;
	}
	
	// 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1040(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1040", paramMap);
		return defaultList;
	}
	
	// 사용자 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1050", paramMap);
		return defaultList;
	}
	
	// 관리자 권한 등록
	public int intrAuthProc1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1010", paramMap);
		return resInt;
	}
	
	// 관리자 권한 수정
	public int intrAuthProc1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.intrAuthProc1020", paramMap);
		return resInt;
	}
	
	// 관리자 권한 삭제 
	public int intrAuthProc1030(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1030", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 삭제 처리
	public int intrAuthProc1040(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1040", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 저장 처리
	public int intrAuthProc1050(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1050", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 삭제 처리
	public int intrAuthProc1060(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1060", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 저장 처리
	public int intrAuthProc1070(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1070", paramMap);
		return resInt;
	}

	// 로그인 권한 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1060(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1060");
		return defaultList;
	}
}
