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
	public List<HashMap<String, Object>> intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1010", paramMap);
		return defaultList;
	}

	// 결재 상세 정보 조회
	public HashMap<String, Object> intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1020", paramMap);
		return defaultInfo;
	}

	// 결재선 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1030", paramMap);
		return defaultList;
	}
	
	// 현재 결재 상태 조회
	public HashMap<String, Object> intrAprvInqy1040(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1040", paramMap);
		return defaultInfo;
	}

	// 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1050", paramMap);
		return defaultList;
	}

	// 나의 기안 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1060(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1060", paramMap);
		return defaultList;
	}

	// 나의 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1070(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1070", paramMap);
		return defaultList;
	}
	
	// 기안문 정보 등록
	public int intrAprvProc1010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// 기안문 결재선 등록
	public int intrAprvProc1020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc10101020", tempMap);
		return resInt;
	}
	
	// RSLT 데이터 NULL 처리
	public int intrAprvProc1030(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101021", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO 현 단계로 처리
	public int intrAprvProc1040(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc10101022", paramMap);
		return resInt;
	}

	// 현 단계 회수로 변경 (INTR_APRV)
	public int intrAprvProc1050(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1050", paramMap);
		return resInt;
	}

	// 현 단계 회수로 변경 (INTR_APRV_LINE)
	public int intrAprvProc1060(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1060", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 (INTR_APRV)
	public int intrAprvProc1070(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1070", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 (INTR_APRV_LINE)
	public int intrAprvProc101080(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc101080", paramMap);
		return resInt;
	}
}
