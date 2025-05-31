package com.intr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class QueryDao {
	//
	@Autowired
	SqlSession sqlsession;

	// ���� �Է� ��ȸ
	public List<HashMap<String, Object>> intrQueryInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("query.intrQueryInqy1021", paramMap);
		return defaultList;
	}

	// ���� �Է� ��ȸ (����)
	public List<Map<String, Object>> intrQueryInqy1031(Model model, HashMap<String, Object> paramMap) {
		//
		List<Map<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("query.intrQueryInqy1031", paramMap);
		return defaultList;
	}
	
	// ���� �Է� ó��
	public int intrQueryProc1011(Model model, HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("query.intrQueryProc1011", paramMap);
		return resInt;
	}

}
