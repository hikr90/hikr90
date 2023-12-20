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
	public List<HashMap<String, Object>> intrBoardInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("board.intrBoardInqy10101010", paramMap);
		return defaulList;
	}
	
	// 공지사항 목록 건수 조회
	public HashMap<String, Object> intrBoardInqy10101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("board.intrBoardInqy10101011", paramMap);
		return defaultInfo;
	}

	// 공지사항 상세 조회
	public HashMap<String, Object> intrBoardInqy10102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("board.intrBoardInqy10102010", paramMap);
		return defaultInfo;
	}
	
	// 관리자 공지사항 등록
	public int intrBoardProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("board.intrBoardProc10101010", paramMap);
		return resInt;
	}

	// 관리자 공지사항 삭제
	public int intrBoardProc10201010(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc10201010", paramMap);
		return resInt;
	}
	
	// 관리자 공지사항 삭제
	public int intrBoardProc10103010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc10103010", paramMap);
		return resInt;
	}
	
	// 공지사항 조회수 증가
	public int intrBoardProc10104010(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProc10104010", paramMap);
		return resInt;
	}

}
