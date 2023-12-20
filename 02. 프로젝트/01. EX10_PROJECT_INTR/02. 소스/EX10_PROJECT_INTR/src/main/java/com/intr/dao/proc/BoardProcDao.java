package com.intr.dao.proc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BoardProcDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 관리자 공지사항 등록
	public int intrBoardProc10101010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("boardProc.intrBoardProc10101010", paramMap);
		return resInt;
	}

	// 관리자 공지사항 삭제
	public int intrBoardProc10201010(HashMap<String,Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("boardProc.intrBoardProc10201010", paramMap);
		return resInt;
	}
	
	// 관리자 공지사항 삭제
	public int intrBoardProc10103010(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("boardProc.intrBoardProc10103010", paramMap);
		return resInt;
	}
	
	// 공지사항 조회수 증가
	public int intrBoardProc10104010(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("boardProc.intrBoardProc10104010", paramMap);
		return resInt;
	}

}
