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
	public List<HashMap<String, Object>> intrAuthInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1011", paramMap);
		return defaultList;
	}

	// 권한 상세 조회
	public HashMap<String, Object> intrAuthInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.intrAuthInqy1021", paramMap);
		//
		return defaultInfo;
	}
	
	// 메뉴 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1031", paramMap);
		return defaultList;
	}
	
	// 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1041(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1041", paramMap);
		return defaultList;
	}
	
	// 사용자 권한 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1051(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1051", paramMap);
		return defaultList;
	}
	
	// 로그인 권한 사용자 목록 조회
	public List<HashMap<String, Object>> intrAuthInqy1061(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1061");
		return defaultList;
	}
	
	// 관리자 권한 등록
	public int intrAuthProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1011", paramMap);
		return resInt;
	}
	
	// 관리자 권한 수정
	public int intrAuthProc1021(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.intrAuthProc1021", paramMap);
		return resInt;
	}
	
	// 관리자 권한 삭제 
	public int intrAuthProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1031", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 삭제 처리
	public int intrAuthProc1041(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1041", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 저장 처리
	public int intrAuthProc1042(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1042", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 삭제 처리
	public int intrAuthProc1051(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1051", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 저장 처리
	public int intrAuthProc1052(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1052", paramMap);
		return resInt;
	}
}
