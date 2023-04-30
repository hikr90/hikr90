package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 관리자 권한 등록
	public int intrAuthProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("authProc.intrAuthProc10101010", paramMap);
		return resInt;
	}
	
	// 관리자 권한 수정
	public int intrAuthProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("authProc.intrAuthProc10201010", paramMap);
		return resInt;
	}
	
	// 관리자 권한 삭제 
	public int intrAuthProc10301010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("authProc.intrAuthProc10301010", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 삭제 처리
	public int intrAuthProc20101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("authProc.intrAuthProc20101010", paramMap);
		return resInt;
	}

	// 관리자 메뉴 권한 저장 처리
	public int intrAuthProc20101020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("authProc.intrAuthProc20101020", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 삭제 처리
	public int intrAuthProc30101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("authProc.intrAuthProc30101010", paramMap);
		return resInt;
	}
	
	// 관리자 사용자 권한 저장 처리
	public int intrAuthProc30101020(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("authProc.intrAuthProc30101020", paramMap);
		return resInt;
	}
}
