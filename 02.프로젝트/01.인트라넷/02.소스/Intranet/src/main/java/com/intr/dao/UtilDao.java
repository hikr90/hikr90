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
	public List<HashMap<String, Object>> intrFileInqy1010(Model model, HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("util.intrFileInqy1010",paramMap);
		return defaultList;
	}
	
	// 단건 파일 조회
	public HashMap<String, Object> intrFileInqy1020(Model model, HashMap<String, Object> paramMap) {
		// 
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("util.intrFileInqy1020",paramMap);
		return defaultInfo;
	}
	
	// 파일 데이터 등록
	public int intrFileProc1010(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("util.intrFileProc1010", tempMap);
		return res;
	}
	
	// 파일 데이터 수정 (CONTENT_IDX N처리)
	public int intrFileProc1030(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc1030", paramMap);
		return res;
	}

	// 파일 데이터 수정 (FILE_IDX Y처리)
	public int intrFileProc1040(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc1040", tempMap);
		return res;
	}
	
	// 파일 데이터 삭제
	public int intrFileProc1050(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc1050", tempMap);
		return res;
	}
}
