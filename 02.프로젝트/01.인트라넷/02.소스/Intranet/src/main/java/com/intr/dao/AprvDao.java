package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvDao {
	//
	@Autowired
	SqlSession sqlsession;

	// 기안 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1011", paramMap);
		return defaultList;
	}

	// 결재 상세 정보 조회
	public HashMap<String, Object> intrAprvInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1021", paramMap);
		return defaultInfo;
	}
	
	// 나의 기안 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1031", paramMap);
		return defaultList;
	}

	// 나의 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1041(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1041", paramMap);
		return defaultList;
	}

	// 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy2011", paramMap);
		return defaultList;
	}
	
	// 결재선 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy2012(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy2012", paramMap);
		return defaultList;
	}
	
	// 현재 결재 상태 조회
	public HashMap<String, Object> intrAprvInqy2013(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy2013", paramMap);
		return defaultInfo;
	}

	// 기안문 정보 등록
	public int intrAprvProc1011(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1011", tempMap);
		return resInt;
	}
	
	// 기안문 결재선 등록
	public int intrAprvProc1021(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1021", tempMap);
		return resInt;
	}
	
	// RSLT 데이터 NULL 처리
	public int intrAprvProc1042(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1031", paramMap);
		return resInt;
	}
	
	// CURR_CONT_SID 현 단계로 처리
	public int intrAprvProc1041(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1041", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 
	public int intrAprvProc1051(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1051", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 
	public int intrAprvProc1052(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1052", paramMap);
		return resInt;
	}
	
	// 현 단계 회수로 변경 
	public int intrAprvProc1061(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1061", paramMap);
		return resInt;
	}

	// 현 단계 회수로 변경 
	public int intrAprvProc1062(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1062", paramMap);
		return resInt;
	}
}
