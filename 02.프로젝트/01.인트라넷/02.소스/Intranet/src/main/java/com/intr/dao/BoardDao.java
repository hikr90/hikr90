package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BoardDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 공지사항 목록
	public List<HashMap<String, Object>> intrBoardInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("board.intrBoardInqy1011", paramMap);
		return defaultList;
	}
	
	// 공지사항 상세 조회
	public HashMap<String, Object> intrBoardInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("board.intrBoardInqy1021", paramMap);
		return defaultInfo;
	}
	
	// 관리자 공지사항 등록
	public int intrBoardProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("board.intrBoardProc1011", paramMap);
		return resInt;
	}

	// 관리자 공지사항 삭제
	public int intrBoardProc1021(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc1020", paramMap);
		return resInt;
	}
	
	// 관리자 공지사항 수정
	public int intrBoardProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc1031", paramMap);
		return resInt;
	}
	
	// 공지사항 조회수 증가
	public int intrBoardProc1032(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc1032", paramMap);
		return resInt;
	}
}
