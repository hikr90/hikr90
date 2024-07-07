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
	public List<HashMap<String, Object>> intrBoardInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("board.intrBoardInqyDao1010", paramMap);
		return defaulList;
	}
	
	// 공지사항 목록 건수 조회
	public HashMap<String, Object> intrBoardInqyDao1020(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("board.intrBoardInqyDao1020", paramMap);
		return defaultInfo;
	}

	// 공지사항 상세 조회
	public HashMap<String, Object> intrBoardInqyDao1030(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("board.intrBoardInqyDao1030", paramMap);
		return defaultInfo;
	}
	
	// 관리자 공지사항 등록
	public int intrBoardProcDao1010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("board.intrBoardProcDao1010", paramMap);
		return resInt;
	}

	// 관리자 공지사항 삭제
	public int intrBoardProcDao1020(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProcDao1020", paramMap);
		return resInt;
	}
	
	// 관리자 공지사항 삭제
	public int intrBoardProcDao1030(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProcDao1030", paramMap);
		return resInt;
	}
	
	// 공지사항 조회수 증가
	public int intrBoardProcDao1040(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("board.intrBoardProcDao1040", paramMap);
		return resInt;
	}

}
