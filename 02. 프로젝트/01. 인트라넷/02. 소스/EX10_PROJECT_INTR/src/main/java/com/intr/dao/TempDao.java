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

	// 템플릿 목록 조회
	public List<HashMap<String, Object>> intrTempInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("temp.intrTempInqy10101010", paramMap);
		return defaulList;
	}
	
	// 템플릿 상세 조회
	public HashMap<String, Object> intrTempInqy10201010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("temp.intrTempInqy10201010", paramMap);
		//
		return defaultInfo;
	}
	
	// 관리자 템플릿 등록
	public int intrTempProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("temp.intrTempProc10101010", paramMap);
		//
		return resInt;
	}
	
	// 관리자 템플릿 수정
	public int intrTempProc10201010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("temp.intrTempProc10201010", paramMap);
		//
		return resInt;
	}
	
	// 관리자 템플릿 삭제 
	public int intrTempProc10301010(HashMap<String, Object> paramMap) {
		int resInt = 0;
		resInt = sqlsession.delete("temp.intrTempProc10301010", paramMap);
		//
		return resInt;
	}

}
