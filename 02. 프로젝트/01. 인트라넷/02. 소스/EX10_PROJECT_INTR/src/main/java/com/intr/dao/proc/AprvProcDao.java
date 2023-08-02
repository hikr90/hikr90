package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AprvProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 기안문 정보 등록
	public int intrAprvProc10101010(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101010", tempMap);
		return resInt;
	}
	
	// 기안문 결재선 등록
	public int intrAprvProc10101020(HashMap<String, Object> tempMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101020", tempMap);
		return resInt;
	}
	
	// RSLT 데이터 NULL 처리
	public int intrAprvProc10101021(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101021", paramMap);
		return resInt;
	}

	// CURR_APRV_SNO 현 단계로 처리
	public int intrAprvProc10101022(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("aprvProc.intrAprvProc10101022", paramMap);
		return resInt;
	}
}
