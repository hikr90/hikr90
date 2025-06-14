package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class MtgDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 회의 시퀀스 조회
	public HashMap<String, Object> intrMtgInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("mtg.intrMtgInqy1010", paramMap);
		return defaultInfo;
	}
	
	// 회의 목록 조회
	public List<HashMap<String, Object>> intrMtgInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("mtg.intrMtgInqy1011", paramMap);
		return defaultList;
	}
	
	// 메인 회의 조회
	public List<HashMap<String, Object>> intrMtgInqy1012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("mtg.intrMtgInqy1012", paramMap);
		return defaultList;
	}
	
	// 회의 상세 조회
	public HashMap<String, Object> intrMtgInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("mtg.intrMtgInqy1031", paramMap);
		return defaultInfo;
	}
	
	// 회의 등록 처리
	public int intrMtgProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("mtg.intrMtgProc1011", paramMap);
		return resInt;
	}
	
	// 회의 삭제 처리
	public int intrMtgProc1021(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("mtg.intrMtgProc1021", paramMap);
		return resInt;
	}
	
	// 회의 수정 처리
	public int intrMtgProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("mtg.intrMtgProc1031", paramMap);
		return resInt;
	}	
}
