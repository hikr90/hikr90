package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class ScheDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 일정 목록 조회
	public List<HashMap<String, Object>> intrScheInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("sche.intrScheInqy1011", paramMap);
		return defaultList;
	}

	// 일정 상세 조회
	public HashMap<String, Object> intrScheInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("sche.intrScheInqy1021", paramMap);
		return defaultInfo;
	}
}
