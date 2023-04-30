package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BoardInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 공지사항 목록
	public List<HashMap<String, Object>> intrBoardInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaulList = null;
		defaulList = sqlsession.selectList("boardInqy.intrBoardInqy10101010", paramMap);
		return defaulList;
	}
	
	// 공지사항 목록 건수 조회
	public HashMap<String, Object> intrBoardInqy10101011(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("boardInqy.intrBoardInqy10101011", paramMap);
		return defaultInfo;
	}

	
	// 공지사항 상세 조회
	public HashMap<String, Object> intrBoardInqy10102010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("boardInqy.intrBoardInqy10102010", paramMap);
		return defaultInfo;
	}
	
}
