package com.intr.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BanrDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 배너 채번
	public HashMap<String, Object> intrBanrInqy1010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("banr.intrBanrInqy1010", paramMap);
		return defaultInfo;
	}
	
	// 배너 조회
	public HashMap<String, Object> intrBanrInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("banr.intrBanrInqy1011", paramMap);
		return defaultInfo;
	}
	
	// 배너 조회 (메인)
	public HashMap<String, Object> intrBanrInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("banr.intrBanrInqy1021", paramMap);
		return defaultInfo;
	}
	
	// 배너 저장 (등록)
	public int intrBanrProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("banr.intrBanrProc1011", paramMap);
		return resInt;
	}
	
	// 배너 저장 (수정)
	public int intrBanrProc1012(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("banr.intrBanrProc1012", paramMap);
		return resInt;
	}

	// 배너 삭제 (수정)
	public int intrBanrProc1021(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("banr.intrBanrProc1021", paramMap);
		return resInt;
	}
}
