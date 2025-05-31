package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class UtilDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 컨텐츠 파일 조회
	public List<HashMap<String, Object>> intrFileInqy1011(Model model, HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("util.intrFileInqy1011",paramMap);
		return defaultList;
	}
	
	// 단건 파일 조회
	public HashMap<String, Object> intrFileInqy1021(Model model, HashMap<String, Object> paramMap) {
		// 
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("util.intrFileInqy1021",paramMap);
		return defaultInfo;
	}
	
	// 파일 등록 처리
	public int intrFileProc1011(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("util.intrFileProc1011", tempMap);
		return res;
	}
	
	// 파일 삭제 처리 (수정)
	public int intrFileProc1021(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc1021", paramMap);
		return res;
	}
	
	// 파일 삭제 처리 (삭제)
	public int intrFileProc1022(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc1022", paramMap);
		return res;
	}

	// 예외 로그 저장
	public int intrExptProc1011(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("util.intrExptProc1011", tempMap);
		return res;
	}
	
	// 공통코드 조회
	public List<HashMap<String, Object>> intrCodeInqy1011(HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("util.intrCodeInqy1011",paramMap);
		return defaultList;
	}
}
