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
	
	// 사용자 목록 조회
	public List<HashMap<String, Object>> intrScheInqyDao1010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("sche.intrScheInqyDao1010", paramMap);
		return defaultList;
	}
}
