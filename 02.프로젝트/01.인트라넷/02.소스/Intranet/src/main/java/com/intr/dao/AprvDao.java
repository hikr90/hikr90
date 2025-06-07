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
}
