package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class TempDao {
	//
	@Autowired
	SqlSession sqlsession;

	// 기안문 양식 목록 조회
	public List<HashMap<String, Object>> intrTempInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("temp.intrTempInqy1011", paramMap);
		return defaultList;
	}
	
	// 기안문 양식 상세 조회
	public HashMap<String, Object> intrTempInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("temp.intrTempInqy1021", paramMap);
		//
		return defaultInfo;
	}
	
	// 기안문 양식 수정
	public int intrTempProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("temp.intrTempProc1011", paramMap);
		return resInt;
	}
}
