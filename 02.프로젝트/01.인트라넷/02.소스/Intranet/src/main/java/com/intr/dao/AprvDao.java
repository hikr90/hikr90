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
	public List<HashMap<String, Object>> intrAprvInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1010", paramMap);
		return defaultList;
	}

	// 결재 상세 정보 조회
	public HashMap<String, Object> intrAprvInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1020", paramMap);
		return defaultInfo;
	}

	// 결재선 목록 조회
	public List<HashMap<String, Object>> intrAprvInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1030", paramMap);
		return defaultList;
	}
	
	// 현재 결재 상태 조회
	public HashMap<String, Object> intrAprvInqyDao1040(Model model, HashMap<String, Object> paramMap) {
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1040", paramMap);
		return defaultInfo;
	}

	// 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqyDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1050", paramMap);
		return defaultList;
	}

	// 나의 기안 목록 조회
	public List<HashMap<String, Object>> intrAprvInqyDao1060(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1060", paramMap);
		return defaultList;
	}

	// 나의 결재 목록 조회
	public List<HashMap<String, Object>> intrAprvInqyDao1070(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqyDao1070", paramMap);
		return defaultList;
	}
	
	// 기안문 정보 등록
	public int intrAprvProcDao1010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProcDao1010", tempMap);
		return resInt;
	}
	
	// 기안문 결재선 등록
	public int intrAprvProcDao1020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProcDao1020", tempMap);
		return resInt;
	}
	
	// RSLT 데이터 NULL 처리
	public int intrAprvProcDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1030", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO 현 단계로 처리
	public int intrAprvProcDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1040", paramMap);
		return resInt;
	}

	// 현 단계 회수로 변경 
	public int intrAprvProcDao1050(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1050", paramMap);
		return resInt;
	}

	// 현 단계 회수로 변경 
	public int intrAprvProcDao1060(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1060", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 
	public int intrAprvProcDao1070(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1070", paramMap);
		return resInt;
	}

	// 현 단계 반송으로 변경 
	public int intrAprvProcDao1080(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProcDao1080", paramMap);
		return resInt;
	}
	
	// 결재 목록 건수 조회
	public HashMap<String, Object> intrAprvInqyDao1080(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1080", paramMap);
		return defaultInfo;
	}

	// 기안 목록 건수 조회
	public HashMap<String, Object> intrAprvInqyDao1090(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqyDao1090", paramMap);
		return defaultInfo;
	}
}
