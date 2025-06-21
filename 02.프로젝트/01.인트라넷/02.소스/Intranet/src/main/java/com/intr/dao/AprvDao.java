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

	// 전자결재 시퀀스 조회
	public HashMap<String, Object> intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1010", paramMap);
		return defaultInfo;
	}
	
	// 기안 목록 조회
	public List<HashMap<String, Object>> intrAprvInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1011", paramMap);
		return defaultList;
	}
	
	// 결재 상세 조회
	public HashMap<String, Object> intrAprvInqy1012(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy1012", paramMap);
		return defaultInfo;
	}
	
	// 결재선 조회
	public List<HashMap<String, Object>> intrAprvInqy1013(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1013", paramMap);
		return defaultList;
	}
	
	// 물품 등록 조회
	public List<HashMap<String, Object>> intrAprvInqy1014(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1014", paramMap);
		return defaultList;
	}
	
	// 정산내역 조회
	public List<HashMap<String, Object>> intrAprvInqy1015(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("aprv.intrAprvInqy1015", paramMap);
		return defaultList;
	}
	
	// 결재 상태 조회
	public HashMap<String, Object> intrAprvInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy2011", paramMap);
		return defaultInfo;
	}
	
	// 잔여 결재 조회
	public HashMap<String, Object> intrAprvInqy3011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("aprv.intrAprvInqy3011", paramMap);
		return defaultInfo;
	}
	
	// 결재 마스터 등록 (APRVMAST)
	public int intrAprvProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1011", paramMap);
		return resInt;
	}
	
	// 결재 이력 등록 (APRVHIST)
	public int intrAprvProc1012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1012", paramMap);
		return resInt;
	}
	
	// 현재 단계, 번호 수정 (APRVHIST)
	public int intrAprvProc1013(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc1013", paramMap);
		return resInt;
	}
	
	// 휴가 신청서 등록 (APRV_REL_LEAV)
	public int intrAprvProc1014(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1014", paramMap);
		return resInt;
	}
	
	// 가지급결의서 등록 (APRV_REL_EXP)
	public int intrAprvProc1015(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1015", paramMap);
		return resInt;
	}
	
	// 물품반출입 신청서 등록 (APRV_REL_ITEM)
	public int intrAprvProc1016(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1016", paramMap);
		return resInt;
	}
	
	// 법인카드 정산서 등록 (APRV_REL_CORP)
	public int intrAprvProc1017(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprv.intrAprvProc1017", paramMap);
		return resInt;
	}
	
	// 결재 단계 수정
	public int intrAprvProc2011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2011", paramMap);
		return resInt;
	}

	// 결재 처리 유형 수정
	public int intrAprvProc2012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2012", paramMap);
		return resInt;
	}
	
	// 결재 일련번호 수정
	public int intrAprvProc2013(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("aprv.intrAprvProc2013", paramMap);
		return resInt;
	}
}
