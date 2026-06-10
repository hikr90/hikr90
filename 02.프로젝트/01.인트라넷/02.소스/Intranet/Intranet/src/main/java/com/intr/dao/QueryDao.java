package com.intr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QueryDao {
	//
	@Autowired
	SqlSession sqlsession;

	// Äõ¸® ÀÔ·Â Á¶È¸
	public List<HashMap<String, Object>> intrQueryInqy1021(HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("query.intrQueryInqy1021", paramMap);
		return defaultList;
	}

	// Äõ¸® ÀÔ·Â Á¶È¸ (¿¢¼¿)
	public List<Map<String, Object>> intrQueryInqy1031(HashMap<String, Object> paramMap) {
		//
		List<Map<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("query.intrQueryInqy1031", paramMap);
		return defaultList;
	}
	
	// Äõ¸® ÀÔ·Â Ã³¸®
	public int intrQueryProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("query.intrQueryProc1011", paramMap);
		return resInt;
	}

}
