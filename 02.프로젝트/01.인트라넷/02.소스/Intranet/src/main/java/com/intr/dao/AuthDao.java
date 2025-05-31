package com.intr.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class AuthDao {
	//
	@Autowired
	SqlSession sqlsession;
	
	// ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy1011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy1011", paramMap);
		return defaultList;
	}

	// ���� �� ��ȸ
	public HashMap<String, Object> intrAuthInqy1021(Model model, HashMap<String, Object> paramMap) {
		//
		HashMap<String, Object> defaultInfo = null;
		defaultInfo = sqlsession.selectOne("auth.intrAuthInqy1021", paramMap);
		//
		return defaultInfo;
	}
	
	// �޴� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy2011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy2011", paramMap);
		return defaultList;
	}
	
	// ����� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy3011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy3011", paramMap);
		return defaultList;
	}
	
	// ����� ���� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy4011(Model model, HashMap<String, Object> paramMap) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy4011", paramMap);
		return defaultList;
	}
	
	// �α��� ���� ����� ��� ��ȸ
	public List<HashMap<String, Object>> intrAuthInqy5011(Model model) {
		//
		List<HashMap<String, Object>> defaultList = null;
		defaultList = sqlsession.selectList("auth.intrAuthInqy5011");
		return defaultList;
	}
	
	// ���� ���
	public int intrAuthProc1011(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1011", paramMap);
		return resInt;
	}
	
	// ���� ����
	public int intrAuthProc1021(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.update("auth.intrAuthProc1021", paramMap);
		return resInt;
	}
	
	// ���� ���� 
	public int intrAuthProc1031(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1031", paramMap);
		return resInt;
	}

	// �޴� ���� ���� ó��
	public int intrAuthProc1041(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.delete("auth.intrAuthProc1041", paramMap);
		return resInt;
	}

	// �޴� ���� ���� ó��
	public int intrAuthProc1042(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1042", paramMap);
		return resInt;
	}
	
	// ����� ���� ���� ó��
	public int intrAuthProc1051(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1051", paramMap);
		return resInt;
	}
	
	// ����� ���� ���� ó��
	public int intrAuthProc1052(HashMap<String, Object> paramMap) {
		//
		int resInt = 0;
		resInt = sqlsession.insert("auth.intrAuthProc1052", paramMap);
		return resInt;
	}
}
