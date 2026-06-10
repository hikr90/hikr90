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
	public List<HashMap<String, Object>> authInqyDao1010(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.authInqyDao1010", paramMap);
		return defaultList;
	}

	// 권한 상세 조회
	public HashMap<String, Object> authInqyDao1020(HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.authInqyDao1020", paramMap);
		//
		return defaultInfo;
	}
	
	// 메뉴 권한 목록 조회
	public List<HashMap<String, Object>> authInqyDao2010(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.authInqyDao2010", paramMap);
		return defaultList;
	}
	
	// 사용자 목록 조회
	public List<HashMap<String, Object>> authInqyDao3010(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.authInqyDao3010", paramMap);
		return defaultList;
	}
	
	// 사용자 권한 목록 조회
	public List<HashMap<String, Object>> authInqyDao4010(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.authInqyDao4010", paramMap);
		return defaultList;
	}
	
	// 로그인 권한 사용자 목록 조회
	public List<HashMap<String, Object>> authInqyDao5010(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.authInqyDao5010");
		return defaultList;
	}
	
	// 권한 등록
	public int authProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.authProcDao1010", paramMap);
		return resInt;
	}
	
	// 권한 수정
	public int authProcDao1020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.authProcDao1020", paramMap);
		return resInt;
	}
	
	// 권한 삭제 
	public int authProcDao1030(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.authProcDao1030", paramMap);
		return resInt;
	}

	// 메뉴 권한 삭제 처리
	public int authProcDao1040(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.authProcDao1040", paramMap);
		return resInt;
	}

	// 메뉴 권한 저장 처리
	public int authProcDao1050(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.authProcDao1050", paramMap);
		return resInt;
	}
	
	// 사용자 권한 삭제 처리
	public int authProcDao1060(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.authProcDao1060", paramMap);
		return resInt;
	}
	
	// 사용자 권한 저장 처리
	public int authProcDao1070(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.authProcDao1070", paramMap);
		return resInt;
	}
}
