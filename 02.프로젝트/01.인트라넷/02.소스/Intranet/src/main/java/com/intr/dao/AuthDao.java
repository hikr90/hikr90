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
	public List<HashMap<String, Object>> intrAuthInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqyDao1010", paramMap);
		return defaultList;
	}

	// 권한 상세 조회
	public HashMap<String, Object> intrAuthInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.intrAuthInqyDao1020", paramMap);
		//
		return defaultInfo;
	}
	
	// 메뉴 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqyDao1030", paramMap);
		return defaultList;
	}
	
	// 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqyDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqyDao1040", paramMap);
		return defaultList;
	}
	
	// 사용자 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqyDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqyDao1050", paramMap);
		return defaultList;
	}
	
	// 관리자 권한 등록
	public int intrAuthProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProcDao1010", paramMap);
		return resInt;
	}
	
	// 관리자 권한 수정
	public int intrAuthProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.intrAuthProcDao1020", paramMap);
		return resInt;
	}
	
	// 관리자 권한 삭제 
	public int intrAuthProcDao1030(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProcDao1030", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 삭제 처리
	public int intrAuthProcDao1040(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProcDao1040", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 저장 처리
	public int intrAuthProcDao1050(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProcDao1050", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 삭제 처리
	public int intrAuthProcDao1060(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProcDao1060", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 저장 처리
	public int intrAuthProcDao1070(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProcDao1070", paramMap);
		return resInt;
	}

	// 로그인 권한 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqyDao1060(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqyDao1060");
		return defaultList;
	}
}
