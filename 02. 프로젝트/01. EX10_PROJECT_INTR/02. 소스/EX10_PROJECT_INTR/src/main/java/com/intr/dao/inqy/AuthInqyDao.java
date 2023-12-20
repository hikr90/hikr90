package com.intr.dao.inqy;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AuthInqyDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy10101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("authInqy.intrAuthInqy10101010", paramMap);
		return defaultList;
	}

	// ���� �� ��ȸ
	public HashMap<String, Object> intrAuthInqy10201010(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("authInqy.intrAuthInqy10201010", paramMap);
		//
		return defaultInfo;
	}
	
	// �޴� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy20101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("authInqy.intrAuthInqy20101010", paramMap);
		return defaultList;
	}
	
	// ����� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy30101010(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("authInqy.intrAuthInqy30101010", paramMap);
		return defaultList;
	}
	
	// ����� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy30101020(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("authInqy.intrAuthInqy30101020", paramMap);
		return defaultList;
	}
}
