package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestAPIDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// 기안문 목록
	public List<HashMap<String, Object>> intrRestInqy1011(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("rest.intrRestInqy1011", paramMap);
		return defaultList;
	}
}
