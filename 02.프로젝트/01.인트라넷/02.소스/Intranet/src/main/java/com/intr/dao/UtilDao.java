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
	public List<HashMap<String, Object>> intrFileInqy101010(Model model, HashMap<String, Object> paramMap) {
		// 
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("util.intrFileInqy10101010",paramMap);
		return defaultList;
	}
	
	// 단건 파일 조회
	public HashMap<String, Object> intrFileInqy101011(Model model, HashMap<String, Object> paramMap) {
		// 
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("util.intrFileInqy10101011",paramMap);
		return defaultInfo;
	}
	
	// 파일 데이터 등록
	public int intrFileProc10101010(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.insert("util.intrFileProc10101010", tempMap);
		return res;
	}
	
	// 파일 데이터 수정 (CONTENT_IDX N처리)
	public int intrFileProc10101020(HashMap<String, Object> paramMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc10101020", paramMap);
		return res;
	}

	// 파일 데이터 수정 (FILE_IDX Y처리)
	public int intrFileProc10101021(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc10101021", tempMap);
		return res;
	}
	
	// 파일 데이터 삭제
	public int intrFileProc10101030(HashMap<String, Object> tempMap) {
		//
		int res = 0;
		res = sqlsession.update("util.intrFileProc10101030", tempMap);
		return res;
	}
}
